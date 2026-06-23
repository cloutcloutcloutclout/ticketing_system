package com.example.ticketing_system.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
public class User {

    // getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Unique ID
    public Long id;

    public String name;
    public String email;
    public String password;

    // Important Info
    public String role;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
