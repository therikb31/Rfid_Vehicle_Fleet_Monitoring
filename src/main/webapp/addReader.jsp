<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("isLoggedIn")!=null){%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<title>Add Reader</title>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<div class="d-flex justify-content-center" style="margin-top: 100px;">
		<form action="/AddReaderServ" method="post">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="reader_id" name="reader_id"
					class="form-control" placeholder="Enter Reader ID" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="address" name="address"
					class="form-control" placeholder="Enter Address" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="lat" name="lat"
					class="form-control" placeholder="Enter Latitude" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="lon" name="lon"
					class="form-control" placeholder="Enter Longitude" />
			</div>

			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
		</form>
	</div>
</body>
</html>
<%}else{%>
<%@ include file="index.jsp"%>
<%} %>