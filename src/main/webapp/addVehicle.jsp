<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Add Vehicle</title>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<% if ( request.getAttribute("addedVehicle") == "true") { %>
         <%@ include file="./includes/addVehicleSuccessModal.jsp"%>
      <%  } %>
	<div class="d-flex justify-content-center" style="margin-top: 100px;">
		<form action="/AddVehicleServ" method="post">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="vehicle_no" name="vehicle_no"
					class="form-control" placeholder="Enter Vehicle Number" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="type_name" name="type_name"
					class="form-control" placeholder="Enter Type Name" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="number" id="type_id" name="type_id"
					class="form-control" placeholder="Enter Type ID" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="rfid" name="rfid"
					class="form-control" placeholder="Enter Rfid" />
			</div>

			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
		</form>
	</div>
</body>
</html>