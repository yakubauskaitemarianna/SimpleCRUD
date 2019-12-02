<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
   String message = pageContext.getException().getMessage();
   String exception = pageContext.getException().getClass().toString();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception</title>
</head>
<body>
	<h2>Exception occurred while processing the request</h2>
	<p>Type: <%= exception%></p>
	<p>Message: <%= message %></p>
</body>
</html>