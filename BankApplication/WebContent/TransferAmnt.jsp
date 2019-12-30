<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:9092/BankApplication/TransferAmt">
<table>
<tr>
<td>To</td>
<td><input type="text" name="accountnumber"/></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="text" name="amount"/></td>
</tr>
<tr>
<td><input type="submit"/></td>
</tr>
</table>
</form>
</body>
</html>