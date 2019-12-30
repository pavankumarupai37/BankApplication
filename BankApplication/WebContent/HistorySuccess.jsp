<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini-Statement</title>
</head>
<body>
<h1>Transactions History</h1>
<% HttpSession hs=request.getSession();
	ArrayList temp=(ArrayList)hs.getAttribute("HISTORY");
	out.println(temp);
%>
</body>
</html>