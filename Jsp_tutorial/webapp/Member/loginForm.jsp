<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

		$("#loginBtn").click(function() {

			if ($("#userid").val() == "") {
				alert("아이디를 입력하세요");
				$("#userid").focus();
				return;
			}

			if ($("#pwd").val() == "") {
				alert("비밀번호를 입력하세요");
				$("#pwd").focus();
				return;
			}

			$.ajax({
				type : "post",
				url : "loginPro.jsp",
				data : {
					"userid" : $("#userid").val(),
					"pwd" : $("#pwd").val()
				},
				success : function(resp) {
					
					if (resp.trim() == -1) {
						alert("회원이 아닙니다.회원가입을 해야합니다");
					} else if (resp.trim() == 2) {
						alert("비밀번호 오류 입니다");
					} else if (resp.trim() == 0) {
						alert("로그인 되었습니다.");
						location.href = "memberView.jsp";
					} else if( resp.trim() == 1){
						alert("관리자 입니다.");
						location.href = "memberList.jsp";
					}

				},
				error : function(e) {
					alert("error : " + e);
				}// ajax 
			})
		})// loginbtn.click
	})// document.ready
</script>
<body>
	<div class="container mt-5">
		<h2>로그인</h2>
		<div class="form-group">
			<label for="userid">ID:</label>
			<input type="text" class="form-control" id="userid" placeholder="Enter ID" name="userid">
		</div>

		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
		</div>

		<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
		<button type="button" class="btn btn-secondary" id="cancelBtn">취소</button>
		<button type="button" class="btn btn-secondary" id="createAccountBtn" onclick="location.href='memberForm.jsp'">회원가입</button>
	</div>
</body>
</html>