<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.database.ReaderDAO, com.models.Reader, java.util.*,java.sql.Date" %>

<%
if (session.getAttribute("isLoggedIn") != null) {
%>
<html>
<head>
<meta charset="UTF-8">
<title>Alerts</title>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/alerts.js"></script>
<%@ include file="./includes/navbar.jsp"%>
</head>
<body>
	<%@ include file="./includes/loader.jsp"%>
	<div class="row">
		<div class="col-1 card" style="width: 18rem; margin: 20px; padding: 0px;">
			<h5 class="card-header">Most Used Reader</h5>
			<div class="card-body">
				<p class="card-text" id="mostUsedReader">
				</p>
			</div>
		</div>
	</div>
	<div class="row" id='leastUsedReader'></div>
	<div class="row" id='mostActiveVehicle'></div>
</body>
</html>
<%
} else {
%>
<%@ include file="index.jsp"%>
<%
}
%>