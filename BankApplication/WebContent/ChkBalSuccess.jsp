<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>
<% HttpSession hs=request.getSession();
	String balance=(String)hs.getAttribute("BALANCE");
	out.println("Your Balance:"+balance);
%>
</body>
</html>