<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
							<h2>Login</h2>
							<p style="color: red;">${errorString}</p>
						</header>
						
							<form name="clientInformation" method="post" action="/WebApp/login" style="
							    margin: auto;
							    width: 50%;
							">
								<div class="row gtr-uniform gtr-50">
									<div class="col-12 col-12-xsmall">																								
										<input type="text" name="userName" value="" placeholder="Username">
									</div>
									<div class="col-12 col-12-xsmall">
										<input type="password" name="password" value="" placeholder="Password"> 
									</div>
									<div class="col-12 col-12-xsmall" style="
									    margin: auto;
									    width: 50%;
									">
										<ul class="actions">
												<li><input type="submit" value="Submit" class="primary"></li>
												<li><input type="reset" value="Reset"></li>
										</ul>
									</div>
								</div>	
									<div class="col-12 col-12-xsmall">																								
										<a href="${pageContext.request.contextPath}/create" >Create An Account</a>
									</div>																																																																
							</form>			
																									      						
					</div>
				</div>

			<!-- Footer -->
				<footer id="footer">
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