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
				<h5 class="card-title">Daily Log</h5>
				<p class="card-text">Contains the Log Events of all the poles
					combined on a given date.</p>
				<form action="DailyLog" id="dailylog" method="post" target="_blank">
					<label for="date">Enter Date:</label> <input type="date"
						name="date" id="date" required><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Pole Log By Date Range</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="PoleLogByDateRange" id="dailylog4" method="post"
					target="_blank">
					<label for="date">From Date:</label> <input type="date"
						name="from_date" id="date6" required><br> <br> <label
						for="date">To Date:</label> <input type="date" name="to_date"
						id="date7" required><br> <br> <label for="date">Enter
						Reader ID:</label> <select class="select-reader" name="pole_no"
						placeholder="Select Reader"></select><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Pole Log By Date</h5>
				<p class="card-text">Contains the Vehicles passing by a given pole for a specific date.</p>
				<form action="PoleLogByDate" method="post"
					target="_blank">
					<label for="date">Enter Date:</label> <input type="date"
						name="date" id="date4" required><br> <br> <label
						for="date">Enter Pole ID:</label><select class="select-reader"
						name="pole_no" splaceholder="Select Reader"></select><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Daily Log By Date Range</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="DailyLogByDateRange" id="dailylog2" method="post"
					target="_blank">
					<label for="date">From Date:</label> <input type="date"
						name="from_date" id="date2" required><br> <br> <label
						for="date">To Date:</label> <input type="date" name="to_date"
						id="date3" required><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Log By Date</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="VehicleLogByDate" id="dailylog5" method="post"
					target="_blank">
					<label for="date">Enter Date:</label> <input type="date"
						name="date" id="date9" required><br> <br> <label
						for="date">Enter Vehicle Number:</label> <select
						class="select-vehicle" name="vehicle_no"
						placeholder="Select Vehicle"></select><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Log By Date Range</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="VehicleLogByDateRange" id="dailylog6" method="post"
					target="_blank">
					<label for="date">From Date:</label> <input type="date"
						name="from_date" id="date11" required><br> <br>
					<label for="date">To Date:</label> <input type="date"
						name="to_date" id="date12" required><br> <br> <label
						for="date">Enter Vehicle Number:</label><select
						class="select-vehicle" name="vehicle_no"
						placeholder="Select Vehicle"></select><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Attendance By Date</h5>
				<p class="card-text">Contains the Log Events of all the poles
					combined on a given date.</p>
				<form action="VehicleAttendanceByDate" id="dailylog7" method="post" target="_blank">
					<label for="date">Enter Date:</label> <input type="date"
						name="date" id="date13" required><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
			</div>
		</div>
		<div class="col card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Vehicle Attendance By Date Range</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="VehicleAttendanceByDateRange" id="dailylog8" method="post"
					target="_blank">
					<label for="date">From Date:</label> <input type="date"
						name="from_date" id="date14" required><br> <br> <label
						for="date">To Date:</label> <input type="date" name="to_date"
						id="date3" required><br> <br>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form>
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