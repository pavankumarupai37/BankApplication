<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<form action="http://localhost:9092/BankApplication/ChangePw">
<center>
<table>
<tr>
<td><label>New Password:</label></td>
<td><input type="password" name="newpassword"/></td>
</tr>
<tr>
<td><label>Confirm Password:</label></td>
<td><input type="password" name="confirmpassword"/></td>
</tr>
<tr>
<td><input type="submit"/></td>
</tr>
</table>
</center>
</form>
</body>
</html>