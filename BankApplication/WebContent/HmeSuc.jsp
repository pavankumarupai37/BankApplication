<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% HttpSession hs1=request.getSession();
	String a=(String)hs1.getAttribute("NAME");
	out.println("thank you"+" "+a+" "+"for your interest");
%>
</body>
</html>