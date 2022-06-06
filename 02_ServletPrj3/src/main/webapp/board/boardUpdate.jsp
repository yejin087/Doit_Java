<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>simple board write</title>
</head>
<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>Board Update</h2>
		</div>
	</div>

	<div class="container">
		<form action="update" method="post" id="frm">
			<input type="hidden" name="num" value="${board.num }" />
			<div class="form-group">
				<label for="userid">Userid:</label>
				<input type="text" class="form-control" id="userid" value="${board.userid }" readonly="readonly" name="userid">
			</div>

			<div class="form-group">
				<label for="subject">Subject:</label>
				<input type="text" class="form-control" id="subject" value="${board.subject }" name="subject">
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" class="form-control" id="email" value="${board.email }" name="email">
			</div>

			<div class="form-group">
				<label for="content">Content:</label>
				<textarea class="form-control" rows="5" name="content" id="content">${board.content }</textarea>
			</div>
			<button class="btn btn-primary">수정하기</button>
			<button type="reset" class="btn btn-secondary">취소하기</button>
		</form>
	</div>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>