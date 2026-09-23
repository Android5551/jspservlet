<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WelcomeView.jsp</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div align="center">
		<h1 style="color: rgb(128, 128, 255)">Welcome to my web site <%=u != null ? "[" + u.getFirstName() + "]"  : "[guest]"%></h1>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>