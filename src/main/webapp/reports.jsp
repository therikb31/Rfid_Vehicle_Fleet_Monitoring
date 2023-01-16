<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
if (session.getAttribute("isLoggedIn") != null) {
%>
<html>
<head>
<meta charset="UTF-8">
<title>Reports</title>
<%@ include file="./includes/links.html"%>
<link rel="stylesheet" href="/css/reports.css">
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<script type="text/javascript" src="../js/reports.js"></script>
</head>
<body>
	<%@ include file="./includes/navbar.jsp"%>
	<div class="row">
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Daily Log</h5><br>
				<p class="card-text">Contains the Log Events of all the poles
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#DailyLog">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="DailyLog" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Daily Log</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="DailyLog" method="post" target="_blank">
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
				<h5 class="card-title">Pole Log By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#PoleLogByDateRange">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="PoleLogByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Pole Log By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="PoleLogByDateRange" method="post" target="_blank">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="from_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="to_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Reader ID:</label>
								</div>
								<div class="col-9">
									<select class="select-reader" name="pole_no" placeholder="Select Reader"></select>
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
				<h5 class="card-title">Pole Log By Date</h5><br>
				<p class="card-text">Contains the Vehicles passing by a given pole for a specific date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#PoleLogByDate">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="PoleLogByDate" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Pole Log By Date</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="PoleLogByDate" method="post" target="_blank">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Reader ID:</label>
								</div>
								<div class="col-9">
									<select class="select-reader" name="pole_no" placeholder="Select Reader"></select>
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
				<h5 class="card-title">Daily Log By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#DailyLogByDateRange">Submit</button>
			</div>
		</div>
	</div>
	<div class="modal fade" id="DailyLogByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Daily Log By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="DailyLogByDateRange" method="post" target="_blank">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="from_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="to_date" id="date14" required>
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
	<div class="row">
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Log By Date</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleLogByDate">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="VehicleLogByDate" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Log By Date</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="VehicleLogByDate" method="post" target="_blank">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Vehicle Number:</label>
								</div>
								<div class="col-9">
									<select class="select-vehicle" name="vehicle_no" placeholder="Select Vehicle"></select>
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
				<h5 class="card-title">Vehicle Log By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleLogByDateRange">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="VehicleLogByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Log By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="VehicleLogByDateRange" method="post" target="_blank"> 
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="from_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="to_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">Enter Vehicle Number:</label>
								</div>
								<div class="col-9">
									<select class="select-vehicle" name="vehicle_no" placeholder="Select Vehicle"></select>
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
				<h5 class="card-title">Vehicle Attendance By Date</h5><br>
				<p class="card-text">Contains the Log Events of all the poles
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleAttendanceByDate">Submit</button>

			</div>
		</div>
		<div class="modal fade" id="VehicleAttendanceByDate" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Attendance By Date</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="VehicleAttendanceByDate" method="post" target="_blank">
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
				<h5 class="card-title">Vehicle Attendance By Date Range</h5><br>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p><br>
					<button class="btn btn-primary" type="submit"
					data-bs-toggle="modal" data-bs-target="#VehicleAttendanceByDateRange">Submit</button>
			</div>
		</div>
		<div class="modal fade" id="VehicleAttendanceByDateRange" tabindex="-1"
		aria-labelledby="addReaderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Vehicle Attendance By Date Range</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="VehicleAttendanceByDateRange" method="post" target="_blank">
						<div class="form-outline mb-4">
							<div class="row">
								<div class="col-3">
									<label for="enterdate">From Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="from_date" id="date14" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-3">
									<label for="enterdate">To Date:</label>
								</div>
								<div class="col-9">
									<input type="date" name="to_date" id="date14" required>
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
	</div>
</body>
<script src="./js/bootstrap.bundle.min.js"></script>

</html>
<%
} else {
%>
<%@ include file="index.jsp"%>
<%
}
%>