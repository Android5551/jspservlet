<%@page import="com.rays.event.bean.EventBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	List<EventBean> list = (List) request.getAttribute("list");
	Iterator<EventBean> it = list.iterator();
	%>

	<%@ include file="/common/header.jsp"%>
	<div align="center">

		<h1 class = "text">Event List</h1>

		<table border="1px" width="100%">

			 <!-- private long eventId; private String eventName; private Date eventDate;
			 private String venue; private String organizer -->
			 
			<tr style="background-color: skyblue">
				<th>Event Id</th>
				<th>Event Name</th>
				<th>Event Date</th>
				<th>Venue</th>
				<th>Organizer</th>
			</tr>

			<%
			while (it.hasNext()) {
				EventBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getEventId()%></td>
				<td><%=bean.getEventName()%></td>
				<td><%=bean.getEventDate()%></td>
				<td><%=bean.getVenue()%></td>
				<td><%=bean.getOrganizer()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="/common/Footer.jsp"%>
</body>
</html>