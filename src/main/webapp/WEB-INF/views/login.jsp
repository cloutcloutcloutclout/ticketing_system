<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %><!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<!-- Display login error message if redirect loop happened on bad credentials -->
<c:if test="${param.error != null}">
    <p style="color: red;">Invalid email or password.</p>
</c:if>

<!-- Display success message after registration -->
<c:if test="${param.registered != null}">
    <p style="color: green;">Registration successful! Please log in.</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">

    <!-- REQUIRED FOR JSP: Hidden CSRF Token Field -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required />
    </div>

    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />
    </div>

    <button type="submit">Sign In</button>
</form>

<p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a></p>

</body>
</html>