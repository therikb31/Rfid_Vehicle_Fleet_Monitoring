<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("isLoggedIn")!=null){%>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Add Vehicle</title>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<div class="d-flex justify-content-center" style="margin-top: 100px;">
		<form action="/AddVehicleServ" method="post">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="vehicle_no" name="vehicle_no"
					class="form-control" placeholder="Enter Vehicle Number" />
			</div>

			Enter Type Name:
			<div class="radio">
				<label><input type="radio" name="type_name" value="TIPPER" checked>TIPPER(1)</label>
			</div>
			<div class="radio">
				<label><input type="radio" name="type_name" value="AUTO-TIPPER">AUTO TIPPER(2)</label>
			</div>
			<div class="radio">
				<label><input type="radio" name="type_name" value="COMPACTOR">COMPACTOR(3)</label>
			</div>
			<div class="radio">
				<label><input type="radio" name="type_name" value="DUMPER">DUMPER(4)</label>
			</div>
			<div class="radio">
				<label><input type="radio" name="type_name" value="STREET-SWEEPING">STREET SWEEPING(5)</label>
			</div><br/>

			<div class="form-outline mb-4">
				<input type="number" id="type_id" name="type_id"
					class="form-control" placeholder="Enter Type ID" />
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