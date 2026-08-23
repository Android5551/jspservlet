<%@page import="com.rays.event.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="/common/header.jsp"%>
	<form action="EventCtl" method="post">

		<div align="center">

			<h1 class = "text">Add Event</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>

			<table class="form-table">

				<tr>
					<th class="greeting">Event Name:<font color="red">*</font></th>
					<td><input type="text" name="eventName" value=""
						placeholder="enter event name"></td>
						<%-- <td style="color: red"><%=request.getAttribute("eventName") != null ? request.getAttribute("eventName") : ""%></td> --%>
						<td style="color: red"><%=ServletUtility.getErrorMessage("eventName", request) %>
				</tr>

				<tr>
					<th class="greeting">Event Date:<font color="red">*</font></th>
					<td><input type="date" name="eventDate" value=""></td>
					<td style="color:red"><%=ServletUtility.getErrorMessage("eventDate", request) %>
				</tr>

				<tr>
					<th class="greeting">Venue:<font color="red">*</font></th>
					<td><input type="text" name="venue" value=""
						placeholder="enter the venue"></td>
						<td style="color:red"><%=ServletUtility.getErrorMessage("eventDate", request) %>				</tr>


				<tr>
					<th></th>
					<td><input type="submit" value="Add Event" class="btn"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="/common/Footer.jsp"%>
</body>
</html>