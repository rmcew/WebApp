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
						
						<!--  Form Validation -->
							<script type="text/javascript">
							function checkForm(){
								var formFilled, gallons, gallonsField, date, dateField,address, addressField;
								var city, cityField, state, stateField, zip, zipField, contact, contactField;
								var tel, telField, email, emailField;
								
								gallons = document.getElementById("gallons").value;
								date = document.getElementById("date").value;
								address = document.getElementById("address").value;
								city = document.getElementById("city").value;
								state = document.getElementById("state").value;
								zip = document.getElementById("zip").value;
								contact = document.getElementById("contact").value;
								tel = document.getElementById("phone").value;
								email = document.getElementById("email").value;
								
								gallonsField = false;
								dateField = false;
								addressField = false;
								cityField = false;
								sateField = false;
								zipField = false;
								contactField = false;
								telField = false;
								emailField = false;
								
								//Gallon Check 
								if(gallons == '0'){
									//alert("Gallons must be more than 0");
									gallonsField = false;
								}
								else{
									gallonsField = true;
								}
								
								//Date Check
								var today = new Date();
								var dd = today.getDate();
								var mm = today.getMonth()+1; //January is 0!
								var yyyy = today.getFullYear();

								if(dd<10) {
								    dd = '0'+dd
								} 

								if(mm<10) {
								    mm = '0'+mm
								} 

								today = yyyy + '-' + mm + '-' + dd;
								
								if(date < today){
									//alert("Date is earlier than todays date");
									dateField = false;
								}
								else{
									dateField = true;
								}
								
								//Address Check
								if(address == ""){
									//alert("Address is empty");
									addressField = false;
								}
								else{
									addressField = true;
								}
								
								//City Check
								if(city == ""){
									//alert("City is empty");
									cityField = false;
								}
								else{
									cityField = true;
								}
								
								//State Check
								if(state == "--"){
									//alert("Select a state");
									stateField = false;
								}
								else{
									stateField = true;
								}
								
								//Zip Check
								if(zip == ""){
									//alert("zip is empty");
									zipField = false;
								}
								else{
									zipField = true;
								}
								
								//Contact Check
								if(contact == ""){
									//alert("Contact name is empty");
									contactField = false;
								}
								else{
									contactField = true;
								}
								
								//Tel Check
								if(tel == ""){
									//alert("Contact Phone is empty ");
									telField = false;
								}
								else{
									telField = true;
								}
								
								//Email Check
								if(email == ""){
									//alert("Email is empty");
									emailField = false;
								}
								else{
									emailField = true;
								}
								
							    knapp = document.querySelector('#getprice')
							    
							    var fullForm = true;
							    	
							    if (fullForm == (gallonsField && dateField && addressField && cityField && stateField && zipField && contactField && telField && emailField))
							   	{
							    	knapp.disabled = false;
							    }
							    else{
							    	knapp.disabled = true;
							    }
							    
							}
							
							//Pricing Module 
							function getPrice(){
								var price, gallonPrice, localFactor, historyFactor, requestFactor, profitFactor, fluctuation;
								
								gallonPrice = 2.19;
								
								if(document.getElementById("state").value == "TX"){
									localFactor = .02;
								}
								else{
									localFactor = .04;
								}
							
								if ('${numQuotes >= 1}') {
									historyFactor = .02;
									
								}
								else
									historyFactor=.04;
										
								if(document.getElementById("gallons").value > '1000'){
									requestFactor = .02;
								}
								else{
									requestFactor = .03;
								}
								
								profitFactor = .05;
								fluctuation = .04;
								
								price = (gallonPrice*(localFactor + historyFactor + requestFactor + profitFactor + fluctuation)+ gallonPrice);
								total = (document.getElementById("gallons").value * price);
								
								//Set variables to be displayed
								document.getElementById("price").value = "Suggested Price: $" + price.toFixed(2);
								document.getElementById("total").value = "Total Price: $" + total.toFixed(2);
								
								//Set variables to be sent to database
								document.getElementById("suggestedPrice").value = price.toFixed(2);
								document.getElementById("amount").value = total.toFixed(2);
								document.getElementById("submit").disabled = false;
							}
							</script>
						

						<!-- Form -->
							<section>
								<h3>Personal Information</h3>
								<form name="clientInformation" method="post" action="${pageContext.request.contextPath}/request-a-quote">
									<div class="row gtr-uniform gtr-50">
										<div class="col-6 col-12-xsmall">
											<input type="number" id="gallons" name="gallonsRequested" value="" placeholder="Gallons Requested" min=0 required onKeyup= "checkForm()"/>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="date" id="date" name="date" value="" placeholder="Date" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id="address" name="address" value="" placeholder="Address" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id ="city" name="city" value="" placeholder="City" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<select id="state" name="state" onKeyup= checkForm() required>
												<option value="--">State</option>
												<option value="AL">Alabama</option>
												<option value="AK">Alaska</option>
												<option value="AZ">Arizona</option>
												<option value="AR">Arkansas</option>
												<option value="CA">California</option>
												<option value="CO">Colorado</option>
												<option value="CT">Connecticut</option>
												<option value="DE">Delaware</option>
												<option value="DC">District Of Columbia</option>
												<option value="FL">Florida</option>
												<option value="GA">Georgia</option>
												<option value="HI">Hawaii</option>
												<option value="ID">Idaho</option>
												<option value="IL">Illinois</option>
												<option value="IN">Indiana</option>
												<option value="IA">Iowa</option>
												<option value="KS">Kansas</option>
												<option value="KY">Kentucky</option>
												<option value="LA">Louisiana</option>
												<option value="ME">Maine</option>
												<option value="MD">Maryland</option>
												<option value="MA">Massachusetts</option>
												<option value="MI">Michigan</option>
												<option value="MN">Minnesota</option>
												<option value="MS">Mississippi</option>
												<option value="MO">Missouri</option>
												<option value="MT">Montana</option>
												<option value="NE">Nebraska</option>
												<option value="NV">Nevada</option>
												<option value="NH">New Hampshire</option>
												<option value="NJ">New Jersey</option>
												<option value="NM">New Mexico</option>
												<option value="NY">New York</option>
												<option value="NC">North Carolina</option>
												<option value="ND">North Dakota</option>
												<option value="OH">Ohio</option>
												<option value="OK">Oklahoma</option>
												<option value="OR">Oregon</option>
												<option value="PA">Pennsylvania</option>
												<option value="RI">Rhode Island</option>
												<option value="SC">South Carolina</option>
												<option value="SD">South Dakota</option>
												<option value="TN">Tennessee</option>
												<option value="TX">Texas</option>
												<option value="UT">Utah</option>
												<option value="VT">Vermont</option>
												<option value="VA">Virginia</option>
												<option value="WA">Washington</option>
												<option value="WV">West Virginia</option>
												<option value="WI">Wisconsin</option>
												<option value="WY">Wyoming</option>
											</select>			
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id="zip" name="zip" value="" placeholder="Zip" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id="contact" name="contactName" value="" placeholder="Contact Name" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="tel" id="phone" name="contactPhone" value="" placeholder="Contact Phone" onKeyup= checkForm() required>
										</div>					
										<div class="col-6 col-12-xsmall">
											<input type="email" id="email" name="deliveryEmail" value="" placeholder="Delivery Email" onKeyup= checkForm() required>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id="price" name="price" value="" placeholder="Suggested Price" readonly>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" id="total" name="total" value="" placeholder="Total Amount Due" readonly>
										</div>		
										<div class="col-6 col-12-xsmall">
											<input type="hidden" id="suggestedPrice" name="suggestedPrice" value="" >
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="hidden" id="amount" name="amount" value="" >
										</div>											
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" value="Submit" id="submit" class="primary" disabled/></li>
												<li><input type="reset" value="Reset" /></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li><input type="button" value="Get Suggested Price" class="secondary" id=getprice onClick= getPrice() disabled/></li>									
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