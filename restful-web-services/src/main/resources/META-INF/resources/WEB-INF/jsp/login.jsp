<html>
	<head>
		<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
		<title> Login </title>
	</head>
	<body>
		<div class="container">
			<h1>Login</h1> 
			<pre>${errorMessage}</pre>
			<hr>
			<form method="post">
				Name: <input type="text" name="name">
				Password: <input type="text" name="password">
				<input type="submit">
			</form>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		</div>
	</body>
</html>