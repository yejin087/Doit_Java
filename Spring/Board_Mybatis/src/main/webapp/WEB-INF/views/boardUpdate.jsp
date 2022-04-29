<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>Board Update</h2>
	</div>
</div>
<div class="container">
	<h3>${board.writer}님의글</h3>
	<input type="hidden" id ="num" value="${board.num}">
	<div class="form-group">
		<label for="title">Title :</label>
		<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${board.title}">
	</div>


	<div class="form-group">
		<label for="content">Content:</label>
		<textarea class="form-control" rows="5" cols="50" name="content" id="content">${board.content}</textarea>
	</div>

	<button class="btn btn-primary" id="btnUpdate">Update Submit</button>

</div>

<script>
$("#btnUpdate").click(function(){
	
	var putString = {
			"content" : $("#content").val(),
			"title" : $("#title").val(),
			"num" : $("#num").val()
		}
	
	$.ajax({
		type :"put",
		url : "/board/update",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(putString),
		success : function(resp){
			alert(resp)
			location.href = "/board/list"
		},
		error : function(e){
			alert("error : " + e)
		}
	})
})//btnUpdate.click

</script>

<%@include file="includes/footer.jsp"%>