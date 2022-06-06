<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>로그인</h2>
		</div>
	</div>
	<div class="container">
		<form action="loginPro" method="post">
			<div class="form-group">
				<label for="id">ID:</label>
				<input type="text" class="form-control" id="id" placeholder="Enter ID" name="username">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
			</div>

			<button class="btn btn-primary" id="btnLogin">Login</button>
		</form>
	</div>
</body>

</html>