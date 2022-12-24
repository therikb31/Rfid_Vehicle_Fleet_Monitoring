<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("isLoggedIn")!=null){%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
        content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="#" />
<title>Dashboard</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/dashboard.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<div class="mycontainer">
		<div class="row"><%@ include file="./includes/navbar.jsp"%></div>
		<div class="row">
			<div class="col-md-auto sidebar overflow-auto"><%@ include
					file="./includes/sidebar.html"%></div>
			<div class="col-3 overflow-auto">
				<!-- <div class="row" style="background-color: blue; height: 50%;">.</div>
				<div class="row" style="background-color: green; height: 50%;">.</div>
 -->			</div>
			<div class="col"><%@ include file="./includes/map.jsp"%></div>
			
			<script src="../js/dashboard.js"></script>
		</div>
	</div>
</body>
</html>
<%}else{%>
<%@ include file="index.jsp"%>
<%} %>
