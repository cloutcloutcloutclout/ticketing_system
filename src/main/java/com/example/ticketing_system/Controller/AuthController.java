package com.example.ticketing_system.Controller;

import com.example.ticketing_system.Model.RegisterRequest;
import com.example.ticketing_system.Model.User;
import com.example.ticketing_system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // bring the passwordEncoder and userRepo


    // Map a basic "/" to "/login" instead
    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }


    // Login
    @GetMapping("/login")
    public String login(){
        return "login";
    }




    // Adds a new RegisterRequest model for a user who wants to register, doesn't include role
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("RegisterRequest", new RegisterRequest());
        return "register";
    }

    // Post register account creation
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, Model model){

        // Simple checks to see if name is blank etc
        if (request.getName() == null || request.getName().isBlank()
                || request.getEmail() == null || request.getEmail().isBlank()
                || request.getPassword() == null || request.getPassword().isBlank()) {
            model.addAttribute("error", "All fields are required.");
            model.addAttribute("registerRequest", request);
            return "register";
        }

        // Simple check for email existence
        if (userRepository.existsByEmail(request.getEmail())) {
            model.addAttribute("error", "Email already registered.");
            model.addAttribute("registerRequest", request);
            return "register";
        }

        // Finally creates user after all checks and encodes
        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                "ROLE_USER"
        );

        // saves the user data and directs into registered
        userRepository.save(user);
        return "redirect:/login?registered";
    }
















}
