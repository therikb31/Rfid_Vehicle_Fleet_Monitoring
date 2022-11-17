<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<title>Add RFID</title>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<div class="d-flex justify-content-center" style="margin-top: 100px;">
		<form action="/AddRfidServ" method="post">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="rfid" name="rfid"
					class="form-control" placeholder="Enter RFID" />
			</div>
			
			<div class="form-outline mb-4">
				<input type="text" id="vehicle_no" name="vehicle_no"
					class="form-control" placeholder="Enter Vehicle_No" />
			</div>
			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
		</form>
	</div>
</body>
</html>