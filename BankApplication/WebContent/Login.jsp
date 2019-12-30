<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>
<form action="http://localhost:9092/BankApplication/Login">
<center><h1>Welcome To Bank</h1>
<table>
<tr>
<td>Customer ID</td>
<td><input type="text" name="id" placeholder="Enter customer ID"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" placeholder="Enter your password"/></td>
</tr>
<tr>
<td><input type="submit"/></td>
</tr>
</table>
</center>
</form>
<form action="http://localhost:9092/BankApplication/ForgotPassword.jsp">
<input type="submit" name="ForgotPassword"/>
</form>
</body>
</html>