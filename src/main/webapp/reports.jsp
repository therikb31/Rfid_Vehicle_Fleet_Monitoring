<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reports</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/reports.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/reports.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-1 card" style="width: 18rem; margin: 20px;">
			<div class="card-body" >
				<h5 class="card-title">Daily Log</h5>
				<p class="card-text">Contains the Log Events of all the readers
					combined on a given date.</p>
				<form action="DailyLog" id="dailylog">
					<label for="date">Enter Date:</label> <input type="date"
						name="date" id="date"><br>
					<br>
					<button class="btn btn-primary" onclick="dailylog()" type="button">Submit</button>
				</form>
			</div>
		</div>
		<div class="col-1 card" style="width: 18rem; margin: 20px;">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
</body>
</html>