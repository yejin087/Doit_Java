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
			<h2>Board Write</h2>
		</div>
	</div>

	<div class="container">
		<form action="write" method="post">
			<div class="form-group">
				<label for="userid">UserId :</label>
				<input type="text" class="form-control" id="userid" placeholder="Enter name" name="userid" value="${sessionScope.sUser.userid}"  readonly>
			</div>

			<div class="row">
				<div class="col">
					<label for="subject">Subject:</label>
					<input type="text" class="form-control" id="userid" placeholder="Enter subject" name="subject">
				</div>
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
			</div>

			<div class="form-group">
				<label for="content">Content:</label>
				<textarea class="form-control" rows="5" cols="50" name="content" id="content"></textarea>
			</div>

			<button class="btn btn-primary">글쓰기</button>
		</form>
	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>