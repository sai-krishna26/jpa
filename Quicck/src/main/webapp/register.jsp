<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <title>Register</title>
</head>

<body>
<h1>Welcome to Register</h1>

<nav>
    <a href="home">Home</a>
    <br>
    <br>
    <a href="readAllRegister">Read All Registers</a>
    <br>
    <br>
</nav>

<form action="register" method="post">

    <h1 style="color: green">${message}</h1>
    <h1 style="color: red">${rmessage}</h1>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br>

    <label for="graduationDate">Graduation Date:</label>
    <input type="date" id="graduationDate" name="graduationDate" required><br>

    <label for="institute">Institute:</label>
    <input type="text" id="institute" name="institute"><br>

    <input type="submit" value="Register">
    
</form>
</body>
</html>