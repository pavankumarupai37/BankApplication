<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h1>Login Success</h1>
<form action ="http://localhost:9092/BankApplication/CheckBal">
<center>
<table>
<tr>
<td><a href="CheckBal">Click here to check balance</a><br></td>
</tr>
<tr>
<td><a href="ChangePw.jsp">Click here to change password</a></td>
</tr>
<tr>
<td><a href="TransferAmnt.jsp">Click here to Transfer Amount</a></td>
</tr>
<tr>
<td><a href="GetStatement">Click here to get Mini-Statement</a></td>
</tr>
<tr>
<td><a href="ApplyLoan.jsp">Click here to Apply Loan</a></td>
</tr>
<tr>
<td><a href="Logout">Click here to Logout</a></td>
</tr>
</table>
</center>
</form>
</body>
</html>