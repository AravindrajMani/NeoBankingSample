 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome page</title>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script type="text/javascript">
	
		function showBalance(){
			$.ajax({
				url: 'api/getBalance',
				type: "GET",
				success: function(result) {
					document.getElementById("balanceValue").innerHTML = result;				
					document.getElementById("balResult").style.display = "block";
				},
				error: function(result) {
					console.log(result);
				}

			});
				
		}
	
		function addAmount(){
			
			var amount = $("#deposit").val();
			var data = {amount: amount}
			
			$.ajax({
				url: 'api/addAmount',
				data: data,
				type: "POST",
				success: function(result) {
					if(result=="success"){
							document.getElementById("added").style.display = "block";
						}				
				},
				error: function(result) {
					console.log(result);
				}
			});
			
			document.getElementById("addAmount").style.display = "none";
			
		}
		
		function withdrawal(){
			
			var withdrawAmount = $("#withdrawal").val();
			var data = {withdrawAmount: withdrawAmount}
			
			$.ajax({
				url: 'api/withdrawAmount',
				data: data,
				type: "POST",
				success: function(result) {	
					if(result=="success"){
						document.getElementById("withdrawn").style.display = "block";
					}
				},
				error: function(result) {
					console.log(result);
				}

			});
			
			document.getElementById("withdraw").style.display = "none";
				
		}
		function showAddInput(){
			document.getElementById("addAmount").style.display ="block";
			
		}
		function showDrawInput(){
			document.getElementById("withdraw").style.display ="block";
			
		}
		
		
	</script>
	<style>
		#balResult, #added, #addAmount, #withdraw, #withdrawn{
			display: none;
		}
		
		.link{
			text-decoration: underline;
		}
		
	</style>
	
</head>
<body>

	<h1>Welcome</h1>
	
	<h3>Choose your Service</h3>
	
	<p class="link"><a onclick="showBalance()">Balance Enquiry</a></p>
	<p class="link"><a onclick="showAddInput()">Add money</a></p>
	<p class="link"><a onclick="showDrawInput()">Withdraw money</a></p>
	
	<div id="balResult">
		<h3>You have <span id="balanceValue"></span> in your account</h3>
	</div>
	
	<div id="addAmount">
		<p> Enter amount :
			<input type="text" id="deposit">
		</p>
		<p>
			<button onclick="addAmount()">Submit</button>
		</p>
	</div>
	<div id="added">
		<h2>Money added successfully into your account</h2>
	</div>
	
	<div id="withdraw">
		<p> Enter amount To withdraw :
			<input type="text" id="withdrawal">
		</p>
		<p>
			<button onclick="withdrawal()">Submit</button>
		</p>
	</div>
	<div id="withdrawn">
		<h2>Money withdrawn successfully from your account</h2>
	
	</div>
	
</body>
</html>