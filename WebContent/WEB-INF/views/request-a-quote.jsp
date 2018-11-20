<!DOCTYPE HTML>
<!--
	Landed by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Elements - Landed by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		<div id="page-wrapper">
			<jsp:include page="_topMenu.jsp"></jsp:include>
			<!-- Main -->
				<div id="main" class="wrapper style1">
					<div class="container">
						<header class="major">
							<h2>Request A Quote</h2>							
						</header>

						<!-- Form -->
							<section>
								<h3>Personal Information</h3>
								<form name="clientInformation" method="post" action="${pageContext.request.contextPath}/request-a-quote">
									<div class="row gtr-uniform gtr-50">
										<div class="col-6 col-12-xsmall">
											<input type="number" name="gallonsRequested" value="" placeholder="Gallons Requested" />
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="date" name="date" value="" placeholder="Date">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="address" value="" placeholder="Address">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="city" value="" placeholder="City">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="state" value="" placeholder="State">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="zip" value="" placeholder="Zip">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="contactName" value="" placeholder="Contact Name">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="tel" name="contactPhone" value="" placeholder="Contact Phone">
										</div>					
										<div class="col-6 col-12-xsmall">
											<input type="email" name="deliveryEmail" value="" placeholder="Delivery Email">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="number" name="suggestedPrice" value="" placeholder="Suggested Price">
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="number" name="amount" value="" placeholder="Total Amount Due">
										</div>		
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" value="Submit" class="primary" /></li>
												<li><input type="reset" value="Reset" /></li>
											</ul>
										</div>																																												
									</div>
								</form>
							</section>

					</div>
				</div>

			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
						<li><a href="#" class="icon alt fa-envelope"><span class="label">Email</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>