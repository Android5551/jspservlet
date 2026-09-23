<%@page import="com.rays.event.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%
String uri = request.getRequestURI();
	/* add module */
boolean homeActive = uri.endsWith("WelcomeView.jsp") || uri.endsWith("WelcomeCtl");
boolean modulesActive = uri.contains("Event") || uri.contains("User") || uri.contains("Vehicle");
boolean loginActive = uri.contains("LoginView.jsp") || uri.contains("LoginCtl");
boolean userRegistrationActive = uri.contains("UserRegistrationView.jsp") || uri.contains("UserRegistrationCtl");
%>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>

	<%
	if (user != null) {
	%>
	<div class="header"
		style="display: flex; justify-content: space-between; align-items: center;">

		<div class="greeting">
			Hi,
			<%=user.getFirstName()%></div>


		<div class="nav">

			<%-- <a href="<%=request.getContextPath()%>/WelcomeCtl">Home</a> | --%>
			<%-- <a href="<%=request.getContextPath()%>/WelcomeCtl" class="active">Home</a> --%>
			<a href="<%=request.getContextPath()%>/WelcomeCtl"
				class="<%=homeActive ? "active" : ""%>">Home</a>

			<!-- <div class="dropdown" style="display: inline-block;">
				<button>Modules</button> -->
			<div class="dropdown">
				<!-- <a href="#">Modules</a> -->
				<a href="#" class="<%=modulesActive ? "active" : ""%>">Modules</a>


				<div class="dropdown-content">
					<!-- add module -->
					<a
						href="<%=request.getContextPath()%>/common/ModuleWelcome.jsp?moduleName=Event&listUrl=EventListCtl&addUrl=EventCtl">
						Event </a>  <a
						href="<%=request.getContextPath()%>/common/ModuleWelcome.jsp?moduleName=User&listUrl=UserListCtl.do&addUrl=UserCtl.do">
						User </a>
						<a
						href="<%=request.getContextPath()%>/common/ModuleWelcome.jsp?moduleName=Vehicle&listUrl=VehicleListCtl&addUrl=VehicleCtl">
						Vehicle </a>

				</div>
			</div>

			<a href="<%=request.getContextPath()%>/LoginCtl?operation=logout">Logout</a>

		</div>

	</div>
	<%
	} else {
	%>
	<div class="header"
		style="display: flex; justify-content: space-between; align-items: center;">

		<div class="greeting">Hi, Guest</div>

		<div class="nav">

		

			<a href="<%=request.getContextPath()%>/WelcomeCtl"
				class="<%=homeActive ? "active" : ""%>"> Home </a> <a
				href="<%=request.getContextPath()%>/LoginCtl"
				class="<%=loginActive ? "active" : ""%>"> Login </a> <a
				href="<%=request.getContextPath()%>/UserRegistrationCtl"
				class="<%=userRegistrationActive ? "active" : ""%>"> SignUp </a>

		</div>

	</div>


	<%
	}
	%>

	<hr>
</body>
</html>