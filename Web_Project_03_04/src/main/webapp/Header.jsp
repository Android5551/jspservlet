<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header.jsp</title>
</head>
<body>
	<%
	UserBean u = (UserBean) session.getAttribute("user");
	%>
	<!-- user is logged in -->
	<%
	if (u != null) {
	%>
	<h2>
		Hi,
		<%=u.getFirstName()%></h2>
	<a href="WelcomeCtl">Welcome</a> |
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">LogOut</a>


	<%
	} else {
	%>

	<h2>Hi, Guest</h2>
	<a href="WelcomeCtl">Welcome</a> |
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SignUp</a>
	<%
	}
	%>
	<hr>
</body>
</html>