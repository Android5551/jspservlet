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
<%@include file="Header.jsp" %>

<%
List <UserBean> l = (List <UserBean>) request.getAttribute("list");
request.getAttribute("");


%>
</body>
</html>