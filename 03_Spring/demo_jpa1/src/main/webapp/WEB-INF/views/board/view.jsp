<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>Board Detail</h2>
	</div>
</div>

<div class="container mt-5">
	<h3 id="writer">${board.writer}의글보기</h3>
	<input type="hidden" id="bnum" value="${board.num}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
			<th>조회수</th>
			<td>${board.hitcount }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
	</table>

	<div class="d-flex">
		<div class="form-group">
			<c:if test="${principal.username == board.writer}">
				<button type="button" class="btn btn-secondary btn-sm" id="btnUpdateForm">Update</button>
				<button type="button" class="btn btn-danger btn-sm" id="btnDelete">Delete</button>

			</c:if>
			<button type="button" class="btn btn-dark btn-sm" id="btnList" onclick="location.href='../list'">List</button>
		</div>

	</div>

	<br>
	<br>
	<textarea rows="3" cols="50" id="msg"></textarea>
	<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
	<br>
	<br>
	<p>댓글 목록</p>
	<div id="commentList" class="mt-6"></div>
</div>

<script>

var commentLoad = function(){
	
	$.ajax({
		type : "get",
		url : "/comment/list",
	 	data : {
			"bnum" : $("#bnum").val()
		}
	})
	.done(function(resp){
		var str = "<table class='table'>"
			$.each(resp, function(index, val) {
				str += "<tr>"
				str += "<td>" + val.user.username + "</td>"
				str += "<td>" + val.content + "</td>"
				str += "<td>" + val.regdate + "</td>"
				if ("${principal.username}" == val.user.username) {
					str += "<td>" + "<a href=javascript:fDel("
							+ val.cnum + ")>" + "delete </a>" + "</td>"
				}
				str += "</tr>"
			})// each
		$("#commentList").html(str)
	})
	
}

	function fDel(cnum){
		if(!confirm("댓글을 삭제하시겟습니까?")){
			return;	
		}
		
		$.ajax({
			type : "delete",
			url : "/comment/delete/" + cnum
		})
		.done(function(){
			alert("success delete comment")
			commentLoad()	
		})
		
	}
	
	
$("#btnDelete").click(function(){
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	
	$.ajax({
		type : "delete",
		url : "/board/delete/" + ${board.num},
	})
	.done(function(resp){
		if( resp == "success"){
			alert("success delete")
			location.href = "/board/list"
		}
	})
	.fail(function(){
		alert("fail delete")
	})
	
})

$("#btnUpdateForm").click(function(){
	
	if(confirm("수정하시겠습니까?")){		
		location.href = "/board/update/"+ ${board.num};
	}
	
})

$("#btnComment").click(function(){
	
	if(${empty principal.user}){
		alert("로그인 하세요")
		location.href="/login"
		return;
	}
	
	if($("#msg").val() == ""){
		alert("댓글 내용을 입력하세요")
		return
	}
	
	var postStr = {
			"content" : $("#msg").val(),
			"bnum" : $("#bnum").val()
	}
	
	$.ajax({
		type : "post",
		url : "/comment/insert/${board.num}",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(postStr)
	})
	.done(function(){
		alert("success insert comment ")
		$("#msg").val("")
		commentLoad()
	})
	.fail(function(){
		alert("fail insert comment")
	})
	
	
})




commentLoad()


</script>