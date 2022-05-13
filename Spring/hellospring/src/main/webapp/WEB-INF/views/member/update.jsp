<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>회원 수정</h2>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col">
				<label for="id">id:</label>
				<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly>
			</div>
		</div>


		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
		</div>

		<div class="form-group">
			<label for="pwd_check">Password Check:</label>
			<input type="password" class="form-control" id="pwd_check" placeholder="Enter password check" name="pwd_check">
		</div>


		<div class="form-group">
			<label for="name">name:</label>
			<input type="text" class="form-control" id="name" name="name" value="${member.name}">
		</div>

		<div class="form-group">
			<label for="address">address:</label>
			<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}">
		</div>


		<br>
		<br>

		<button type="button" class="btn btn-secondary" id="btnUpdateAcc">update account</button>
		<button type="button" class="btn btn-danger" id="btnDelAcc">delete account</button>
		<button type="button" class="btn btn-dark" id="btnCancle" onclick="location.href='/myboard/board/list'">cancle</button>

	</div>
</body>

