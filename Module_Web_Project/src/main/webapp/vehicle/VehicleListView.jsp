<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.event.bean.VehicleBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<VehicleBean> list = (List) request.getAttribute("list");
	Iterator<VehicleBean> it = list.iterator();
	%>
	<!-- private long vehicleId;
	private String vehicleName;
	private String model;
	private String color;
	private double price; -->
	
	<%@ include file="/common/header.jsp"%>
	<div align="center">

		<h1 class = "text">Vehicle List</h1>

		<table border="1px" width="100%">

			 
			<tr style="background-color: skyblue">
				<th>Vehicle Id</th>
				<th>Vehicle Name</th>
				<th>Model</th>
				<th>Color</th>
				<th>Price</th>
			</tr>

			<%
			while (it.hasNext()) {
				VehicleBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getVehicleId()%></td>
				<td><%=bean.getVehicleName()%></td>
				<td><%=bean.getModel()%></td>
				<td><%=bean.getColor()%></td>
				<td><%=bean.getPrice()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="/common/Footer.jsp"%>
</body>
</html>