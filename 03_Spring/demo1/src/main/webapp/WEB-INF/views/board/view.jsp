<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/includes/header.jsp"%>
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


			<button type="button" class="btn btn-primary btn-sm" id="btnUpdate">Update</button>
			<button type="button" class="btn btn-danger btn-sm" id="btnDelete">Delete</button>
			<button type="button" class="btn btn-dark btn-sm" id="btnList" onclick="location.href='../list'">List</button>
		</div>

	</div>

	<br>
	<textarea rows="3" cols="50" id="msg"></textarea>
	<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
	<br>
	<br>
	<p>댓글 목록</p>
	<div id="commentList" class="mt-6"></div>
</div>
<script>
	var commentLoad = function() {
		$.ajax({
			type : "post",
			url : "/comment/list",
			data : {
				"bnum" : $("#bnum").val()
			}
		}).done(function(resp) {
			var str = "<table class='table'>"
			$.each(resp, function(index, val) {
				str += "<tr>"
				str += "<td>" + val.userid + "</td>"
				str += "<td>" + val.content + "</td>"
				str += "<td>" + val.regdate + "</td>"
				str += "<td>" + "<a href='javascript:commentDel(" +val.cnum+ ")'>삭제</a>" + "</td>"
			})
			str += "</table>"
			$("#commentList").html(str)
		})
	}
	
	$("#btnUpdate").click(function() {
		if (confirm("수정하시겠습니까?")) {
			location.href = "/board/update/${board.num}"

		}

	})

	$("#btnDelete").click(function() {
		if (!confirm("정말삭제?")) {
			return;
		}

		$.ajax({
			type : "delete",
			url : "/board/delete/${board.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("성공~")
					location.href = "/board/list"
				}
			}
		})
	})

	$("#btnComment").click(function() {

		if ($("#msg").val() == "") {
			alert("댓글 입력하세요")
			return;
		}

		var postString = {
			"content" : $("#msg").val(),
			"bnum" : $("#bnum").val(),
			"userid" : "admin90"
		}

		$.ajax({
			type : "post",
			url : "/comment/insert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(postString)

		}).done(function(resp) {
			alert("insert success")
			$("#msg").val("")
			commentLoad()
		}).fail(function(e) {
			alert("fail")
		})
	})
	
	function commentDel(cnum){
		$.ajax({
			type : "delete",
			url : "/comment/delete/" + cnum
		})	
		.done(function(resp){
			if( resp > 0){
			alert("comment delete success")
			commentLoad()
				
			}
		})
		.fail(function(e){
			alert("fail : " + e)
		})
	}

	commentLoad()
</script>
