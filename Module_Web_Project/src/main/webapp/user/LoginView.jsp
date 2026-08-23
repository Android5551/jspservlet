<%@page import="com.rays.event.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>
	<%@ include file="/common/header.jsp"%>
	<form action="LoginCtl" method="post">

		<div align="center">

			<h1 class = "text">Login</h1>

			<h3 style="color: red"><%=err != null ? err : ""%></h3>
			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

			<table class="form-table">
				<tr>
					<th class = "greeting">Login:<font color="red">*</font></th>
					
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
					<%-- <td style="color: red"><%=request.getAttribute("login") != null ? request.getAttribute("login") : ""%></td> --%>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th class = "greeting">Password:<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
					<td style="color: red"><%=request.getAttribute("password") != null ? request.getAttribute("password") : ""%></td>
				<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Sign In" class = "btn"></td>
				</tr>
			</table>

		</div>

	</form>
	<%@ include file="/common/Footer.jsp"%>
</body>
</html>