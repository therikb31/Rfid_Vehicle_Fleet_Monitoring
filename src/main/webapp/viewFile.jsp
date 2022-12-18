<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("isLoggedIn")!=null){%>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
	<iframe src="D:/Output/${filepath}" width="100%" height="650px"></iframe>
</body>
</html>
<%}else{%>
<%@ include file="index.jsp"%>
<%} %>