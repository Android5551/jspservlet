<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserListView.jsp</title>
</head>
<body>
	<%@include file="Header.jsp"%>

	<%
	List<UserBean> l = (List<UserBean>) request.getAttribute("list");
	int pageSize = (int) request.getAttribute("pageSize");
	int pageNo = (int) request.getAttribute("pageNo");
	Iterator<UserBean> i = l.iterator();
	int index = (pageNo - 1) * pageSize + 1;
	%>
	<form action="UserListCtl" method="post">
		<table align="center" border="1px">
			<tr>
				<th>Index</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login</th>
				<th>DOB</th>
			</tr>
			<%
			while (i.hasNext()) {
				UserBean b = i.next();
			%>

			<tr>
				<td><%=b.getId()%></td>
				<td><%=b.getFirstName()%></td>
				<td><%=b.getLastName()%></td>
				<td><%=b.getLoginId()%></td>
				<td><%=b.getDob()%></td>
			</tr>


			<%
			}
			%>
		</table>
	</form>
</body>
</html>