<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
if (session.getAttribute("isLoggedIn") != null) {
%>
<html>
<head>
<meta charset="UTF-8">
<title>Services</title>
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
<script type="text/javascript" src="../js/reports.js"></script>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<div class="row">
		<div class="col-1 card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Add Vehicle</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="#" id="addVehiclerCard" method="post">
					<button type="button" class="btn btn-primary"
						data-bs-toggle="modal" data-bs-target="#addVehicleModal">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="addVehicleModal" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add Vehicle</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddVehicleServ" method="post">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="vehicle_no">Vehicle No</label>
								</div>
								<div class="col-9">
									<input type="text" id="vehicle_no" name="vehicle_no"
										class="form-control" placeholder="Enter Vehicle Number" />
								</div>
							</div>
							<br />
							<div class="row">
								<div class="col-3">
									<label for="type_name">Vehicle Type</label>
								</div>
								<div class="col-9">
									<select class="form-select" name="type_name" id="type_name">
										<option value="TIPPER">Tipper</option>
										<option value="AUTO TIPPER">Auto Tipper</option>
										<option value="COMPACTOR">Compactor</option>
										<option value="DUMPER">Dumper</option>
										<option value="STREET SWEEPING">Street Sweeper</option>
									</select>
								</div>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%
} else {
%>
<%@ include file="index.jsp"%>
<%
}
%>