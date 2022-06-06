<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>
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

	<div class="form-group">
		<button type="button" class="btn btn-secondary btn-sm" id="btnUpdateForm">update</button>
		<button type="button" class="btn btn-danger btn-sm" id="btnDelete">delete</button>
	</div>

	<br>
	<br>
	<textarea rows="3" cols="50" id="msg"></textarea>
	<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
	<br><br>
	<p>댓글 목록</p>
	<div id="commentList" class="mt-6"></div>
</div>
<script>
	var init = function() {
		$.ajax({
			type : "get",
			url : "/board/reply/commentList",
			data : {
				"bnum" : $("#bnum").val()
			}

		}).done(function(resp) {
			//alert(resp)
			var str = "<table class='table'>"
			$.each(resp, function(index, val){
				str += "<tr>"
				str += "<td>" + val.userid +"</td>"
				str += "<td>" + val.content +"</td>"
				str += "<td>" + val.regdate +"</td>"
				str +=  "<td>" + "<a href=javascript:fdel("+ val.cnum+ ")>" + "delete </a>" + "</td>"
			})// each
			$("#commentList").html(str)
		}).fail(function(e) {
			alert("fail")
		})

	}
	
	function fdel(cnum){
		$.ajax({
			type: "DELETE",
			url : "/board/reply/delete/" + cnum
		}) // ajax
		.done( function(resp){
			alert("no."+ resp + " delete success")
			init()
		})
		.fail( function(e){
			alert("fail to del comment")
		})
		
	} // fdel
	

	$("#btnDelete").click(function() {
		if (!confirm("정말 삭제할까요?"))
			return false

		$.ajax({
			type : "delete",
			url : "/board/delete/${board.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("delete success")
					location.href = "/board/list"
				}
			},
			error : function(e) {
				alert("error : " + e)
			}
		})// ajax
	})// btnDelete.click

	$("#btnUpdateForm").click(function() {
		if (!confirm("수정할까요?"))
			return false;

		location.href = "/board/update/${board.num}"

	})// btnUpdate.click

	$("#btnComment").click(function() {
		if ($("#msg").val() == "") {
			alert("댓글을 입력하세요")
			return;
		}

		var postString = {
			"content" : $("#msg").val(),
			"bnum" : $("#bnum").val(),
			"userid" : "userid"
		}
		$.ajax({
			type : "post",
			url : "/board/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(postString),
			success : function(resp) {
				alert(resp)
				init()
				$("#msg").val("")
			},
			error : function(e) {
				alert("error : " + e)
			}

		}).done(function() {
			alert("댓글 추가")
		}).fail(function() {
			alert("fail")
		})
	})
	
	init()
</script>
<%@include file="includes/footer.jsp"%>