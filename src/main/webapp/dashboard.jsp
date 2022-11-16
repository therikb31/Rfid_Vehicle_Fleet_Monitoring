<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="#" />
<title>Dashboard</title>
<div>
	<%@ include file="./includes/navbar.jsp"%></div>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-auto">
				<%@ include file="./includes/sidebar.html"%>
			</div>
			<div class="col">
				<%@ include file="./includes/map.jsp"%>
			</div>
		</div>
	</div>
	<script src="../js/dashboard.js"></script>
</body>
</html>