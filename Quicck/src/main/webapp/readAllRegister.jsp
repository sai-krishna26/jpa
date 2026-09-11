<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <title>ReadAll</title>
</head>

<body>
<h1><span>All Registers</span></h1>

<nav>
    <a href="home">Home</a>
    <br>
    <br>
    <a href="redirectToRegister">Register</a>
    <br>
    <br>
</nav>

<table border="2">
    <thead>
    <tr>
        <th>Register Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Confirm Password</th>
        <th>Graduation Date</th>
        <th>Institute</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${registerDtoList}" var="register">

        <tr>
            <td>${register.getId()}</td>
            <td>${register.getName()}</td>
            <td>${register.getEmail()}</td>
            <td>${register.getPassword()}</td>
            <td>${register.getConfirmPassword()}</td>
            <td>${register.getGraduationDate()}</td>
            <td>${register.getInstitute()}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>