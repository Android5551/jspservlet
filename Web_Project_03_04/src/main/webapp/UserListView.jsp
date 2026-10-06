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
	int pageNo = (int) request.getAttribute("pageNo");
	int pageSize = (int) request.getAttribute("pageSize");
	Iterator<UserBean> i = l.iterator();

	int index = (pageNo - 1) * pageSize + 1;
	%>
	<div align="center">
		<h1>User List</h1>
		<form action="UserListCtl" method="post">
			<input type="text" name=pageNo value=<%=pageNo%>>
			<table border="1px" width=100%>
				<tr>
					<!-- <th>S.No.</th> -->
					<th>S.No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
				</tr>
				<%
				while (i.hasNext()) {
					UserBean b = i.next();
				%>
				<!-- prints firstName row by row -->
				<tr align="center">
					<td><%=index++%>
					<td><%=b.getFirstName()%></td>
					<td><%=b.getLastName()%></td>
					<td><%=b.getLoginId()%></td>
					<td><%=b.getDob()%></td>
				</tr>

				<%
				}
				%>

			</table>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation" value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>
					<td><input type="submit" name="operation" value="delete"></td>
					<td><input type="submit" name="operation" value="next" <%=l.size() < pageSize ? "disabled" : ""%>></td>
				</tr>	
			</table>
		</form>
	</div>


	<%@include file="Footer.jsp"%>
</body>
</html>