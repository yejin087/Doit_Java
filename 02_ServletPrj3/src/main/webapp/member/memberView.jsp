<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<script src="../js/member.js"></script>


<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>회원 수정</h2>
		</div>
	</div>

	<div class="container">
		<form action="update" method="post" id="frm">
			<input type="hidden" name="userid" value="${member.userid}">
			<div class="form-group">
				<label for="name">Name :</label>
				<input type="text" class="form-control" id="name" name="name" value="${member.name}">
			</div>


			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" class="form-control" id="email" name="email" value="${member.email}">
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
				<label for="phone">phone:</label>
				<input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
			</div>

			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" name="admin" value="0">일반회원
				</label>
			</div>

			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" name="admin" value="1">관리자
				</label>
			</div>
			
			<script>
				if (${member.admin == 0}) {
					$("input:radio[value=0]").attr("checked", true);
				} else {
					$("input:radio[value=1]").attr("checked", true);
				}
			</script>
			
			<br> <br>

			<button type="submit" class="btn btn-primary" id="sendBtn">수정하기</button>
			<button type="reset" class="btn btn-secondary" id="deleteBtn">취소하기</button>
			<button type="button" class="btn btn-danger" id="outBtn">탈퇴하기</button>

		</form>
	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>