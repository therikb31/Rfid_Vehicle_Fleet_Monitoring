<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("isLoggedIn")!=null){%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
        content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="./static/nkda-logo2.png" />
<title>Dashboard</title>
<%@ include file="./includes/links.html"%>
<link rel="stylesheet" href="../css/dashboard.css">

</head>
<body>
	<div class="mycontainer">
		<div class="row"><%@ include file="./includes/navbar.jsp"%></div>
		<div class="row">
			<div class="col-2"><%@ include
					file="./includes/sidebar.html"%></div>
			<div class="col-3 no-gutters">
				<div class="row" style="background-color: #F9F6EE; height: 50%;">.</div>
				<div class="row" style="background-color: #FAF9F6; height: 50%;">.</div>			</div>
			<div class="col"><%@ include file="./includes/map.jsp"%></div>
			
			<script src="../js/dashboard.js"></script>
		</div>
	</div>
</body>
</html>
<%}else{%>
<%@ include file="index.jsp"%>
<%} %>
