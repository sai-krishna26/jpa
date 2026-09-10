<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>

<body>
<h1>Welcome to Register</h1>

<form action="relocateToRegister" method="post">
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