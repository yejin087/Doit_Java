<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>Board Write</h2>
	</div>
</div>
<div class="container">
	<form action="insert" method="post">
		<div class="form-group">
			<label for="title">Title :</label>
			<input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
		</div>

		<div class="row">
			<div class="col">
				<label for="writer">Writer:</label>
				<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
			</div>
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" cols="50" name="content" id="content"></textarea>
		</div>

		<button class="btn btn-primary">Submit</button>
	</form>
</div>


<%@include file="includes/footer.jsp"%>