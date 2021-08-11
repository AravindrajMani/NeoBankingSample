 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign-up page</title>
	<style>
			.error{
				color: red;
				font-size: 130%;
			}
		
			#wrap{
				text-align: center;
				margin:0 auto;	
			}
			#heading{
				color: maroon;
				margin-top: 30px;
			}
			.fields:hover{
				border-color: pink;
			}
			#register{
				background-color: green;
				color: white;
			}
	
	</style>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script type="text/javascript">
	
	function validate() {

		var username = $("#username").val();
		var password = $("#pass").val();
		var firstname = $("#fn").val();
		var lastname = $("#ln").val();
		var data = {
			username: username,
			password: password,
			firstname: firstname,
			lastname: lastname
		}

		$.ajax({
			url: 'api/register',
			data: JSON.stringify(data),
			type: "POST",
			dataType: "Text",
			contentType: 'application/json',
			success: function(result) {
				if (result == "success") {
					window.location.href = 'http://localhost:8080/index';
				}
				console.log(result);
			},
			error: function(result) {
				console.log(result);
			}

		});
	}
	</script>
	
</head>
<body>

	<div id="wrap">
	<form>	
			<h2 id="heading">Sign Up</h2>
			<p>
				 <input type="text" id="username" size="46" placeholder="username*" class="fields">
			</p>
			<p>
				<input type="password"	id="pass" size="46" placeholder="Set A Password*" class="fields">
			</p>
			<p>
				
				<input type="text" id="fn" placeholder="First Name*" class="fields">
				<input type="text"	id="ln" placeholder="Last Name*" class="fields">
			</p>
			
			
			<button type="button" id="register" onclick="validate()"> Get Started </button> 
			
			<br>
			
	</form>
	</div>
	
	
	
</body>
</html>