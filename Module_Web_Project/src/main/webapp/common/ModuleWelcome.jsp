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
<%@ include file="header.jsp"%>
<%
    String moduleName = request.getParameter("moduleName");
    String listUrl = request.getParameter("listUrl");
    String addUrl = request.getParameter("addUrl");
%>

<div class="module-container">

    <h1><%= moduleName %> Management</h1>

    <p>Manage your <%= moduleName.toLowerCase() %>s easily.</p>

    <a href="<%=request.getContextPath()%>/<%=listUrl%>" class="module-btn">
        <%= moduleName %> List
    </a>

    <a href="<%=request.getContextPath()%>/<%=addUrl%>" class="module-btn">
        Add <%= moduleName %>
    </a>

</div>
<%@ include file="Footer.jsp"%>
</body>
</html>
