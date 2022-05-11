<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>


<div class="container">
	<h3 class="mb-3">Board Write</h3>
	<form action="/board/insert" method="post">
		<div class="form-group">
			<label for="title">Title :</label>
			<input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
		</div>

		<div class="row">
			<div class="col">
				<label for="writer">Writer:</label>
				<input type="text" class="form-control" id="writer" placeholder="Enter writer" value="${principal.username}" name="writer" readonly>
			</div>
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" cols="50" name="content" id="content"></textarea>
		</div>

		<button class="btn btn-primary">Submit</button>
	</form>
</div>
