<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page
	import="com.database.ReaderDAO, com.models.Reader, java.util.*,java.sql.Date"%>

<%
if (session.getAttribute("isLoggedIn") != null) {
%>
<html>
<head>
<meta charset="UTF-8">
<title>Alerts</title>

<%@ include file="./includes/links.html"%>    
<%@ include file="./includes/navbar.jsp"%>
<link rel="stylesheet" href="/css/reports.css">
</head>
<body>
<div class="row">
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Pole Activity Log By Date</h5><br>
				<p class="card-text">Contains the activity rate of all Poles for a specific date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#PoleActivityLogByDate">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="PoleActivityLogByDate" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Pole Activity Log By Date</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddVehicleServ" method="post">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
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
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Pole Activity Log By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#PoleActivityLogByDateRange">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="PoleActivityLogByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Pole Activity Log By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddVehicleServ" method="post">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
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
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Activity Log By Date</h5><br>
				<p class="card-text">Contains the activity rate of all Poles for a specific date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleActivityLogByDate">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="VehicleActivityLogByDate" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Activity Log By Date</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddVehicleServ" method="post">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
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
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Activity Log By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleActivityLogByDateRange">Submit</button>
			</div>
		</div>
	</div>
	<div class="modal fade" id="VehicleActivityLogByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Activity Log By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="AddVehicleServ" method="post">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
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
	<script src="./js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%
} else {
%>
<%@ include file="index.jsp"%>
<%
}
%>