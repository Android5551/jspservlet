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
	<form action="VehicleCtl" method="post">

		<div align="center">

			<h1 class = "text">Add Vehicle</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: #ff6b6b"><%=err != null ? err : ""%></h3>

			<table class="form-table">
<!-- private long vehicleId;
	private String vehicleName;
	private String model;
	private String color;
	private double price; -->
				<tr>
					<th class="greeting">Vehicle Name:<font color="#ff6b6b">*</font></th>
					<td><input type="text" name="vehicleName" value=""
						placeholder="enter vehicle name"></td>
						<%-- <td style="color: #ff6b6b"><%=request.getAttribute("eventName") != null ? request.getAttribute("eventName") : ""%></td> --%>
						<td style="color: #ff6b6b"><%=ServletUtility.getErrorMessage("vehicleName", request) %>
				</tr>

				<tr>
					<th class="greeting">Model:<font color="#ff6b6b">*</font></th>
					<td><input type="text" name="model" value=""
					placeholder="enter model name"></td>
					<td style="color:#ff6b6b"><%=ServletUtility.getErrorMessage("model", request) %>
				</tr>

				<tr>
					<th class="greeting">Color:<font color="#ff6b6b">*</font></th>
					<td><input type="text" name="color" value=""
						placeholder="enter the color"></td>
						<td style="color:#ff6b6b"><%=ServletUtility.getErrorMessage("color", request) %>
				</tr>
				<tr>
					<th class="greeting">Price:<font color="#ff6b6b">*</font></th>
					<td><input type="number" name="price" value=""
						placeholder="enter the price"></td>
						<td style="color:#ff6b6b"><%=ServletUtility.getErrorMessage("price", request) %>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="Add Vehicle" class="btn"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="/common/Footer.jsp"%>
</body>
</html>