<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>Register</h1>

<% if (request.getAttribute("error") != null) { %>
<p>
    <%= request.getAttribute("error") %>
</p>
<% } %>

<form:form method="post"
           action="/register"
           modelAttribute="RegisterRequest">

    <label>Name:</label>
    <form:input path="name"/>

    <br><br>

    <label>Email:</label>
    <form:input path="email" type="email"/>

    <br><br>

    <label>Password:</label>
    <form:password path="password"/>

    <br><br>

    <button type="submit">Register</button>

</form:form>

<br>

<p>
    Already have an account?
    <a href="/login">Login here</a>
</p>

</body>
</html>