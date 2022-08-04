<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<script src="../js/member.js"></script>
<html>


<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>로그인</h2>
	</div>
</div>
<div class="container">
	<div class="form-group">
		<label for="userid">ID:</label>
		<input type="text" class="form-control" id="userid" placeholder="Enter ID" name="userid">
	</div>

	<div class="form-group">
		<label for="pwd">Password:</label>
		<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	</div>

	<button type="button" class="btn btn-primary" id="loginBtn">Submit</button>
</div>

</html>

<%@ include file="../include/footer.jsp"%>

