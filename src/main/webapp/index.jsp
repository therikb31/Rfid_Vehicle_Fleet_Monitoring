<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/index.css">
<title>NKDA</title>
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

body {
	max-height: 100vh;
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}

.h-custom {
	height: 100%;
	max-height: calc(100vh - 125px);
}
</style>
<%@ include file="./includes/links.html"%>
</head>
<body>
	<!-- Navbar -->
	<section class="vh-100">
		<!-- Image and text -->
		<nav class="navbar navbar-dark bg-dark d-flex justify-content-center" >
			<a class="navbar-brand"
				style="color: LightGray; font-weight: bold; font-size: 1vw; letter-spacing: 3px;">
				<img src="./static/nkda-logo.png" height="50"
				class="d-inline-block align-top" alt="" style="margin-right: 15px;">
				<h1>NKDA Solid Waste Vehicle Monitoring System</h1> 
				<img src="./static/nkda-logo2.png" height="50"
				class="d-inline-block align-top" alt="" style="margin-left: 15px;">
			</a>
		</nav>
		<div class="flex-grow container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img src="../static/picture.png" class="img-fluid"
						alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="./dashboard" method="post">
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" id="form3Example3" name="employee_id"
								class="form-control form-control-lg"
								placeholder="Enter user id" required />
						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<input type="password" id="form3Example4"
								class="form-control form-control-lg" name="password"
								placeholder="Enter password" required />
						</div>

						<div class="d-flex justify-content-between align-items-center">

							<div class="text-center text-lg-start mt-4 pt-2">
								<button type="submit" class="btn btn-primary btn-lg"
									style="padding-left: 2.5rem; padding-right: 2.5rem; font-size: 1vw;">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Developed and Maintained by
				Kanak Jyoti Udyog</div>
			<!-- Copyright -->
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>