<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="../js/board.js"></script>
<script>
	$(function() {
		$("#delBtn").click(function() {
			if (confirm("정말 삭제 하시겠습니까?")) {
				location.href = "delete?num=${board.num}"
			}
		})// delBtn.click
	})// function
</script>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>Board Detail</h2>
	</div>
</div>

<div class="container mt-5">
	<input type="hidden" id="bnum" value="${board.num}">
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
			<th>조회수</th>
			<td>${board.readcount }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.userid }</td>
			<th>작성일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${board.subject }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
	</table>

	<c:if test="${board.userid == sessionScope.sUser.userid}">
		<button type="button" class="btn btn-primary" onclick="location.href='update?num=${board.num}'">수정하기</button>
		<button class="btn btn-danger" id="delBtn">삭제</button>
	</c:if>

	<div>
		<div class="form-group">
			<label for="msg">comment:</label>
			<textarea class="form-control" rows="2" cols="50" name="msg" id="msg"></textarea>
		</div>
		<button class="btn btn-success" id="commentBtn">comment write</button>
		</br> <br>
		<div>
			댓글 ( <span class="cntSpan"></span> )
		</div>
		<div id="result"></div>
	</div>

</div>

<!-- <script>
	var init = function() {
	$.getJSON("commentlist",
			{"bnum" : $("#bnum").val()},
			function(resp){
			var str = "<table class='table table-hover'>"
			
			$.each( resp.jarr, function(key, val){
				str += "<tr>"
				str += "<td>" + val.msg + "</td>"
				str += "<td>" + val.userid + "</td>"
				str += "<td>" + val.regdate + "</td>"
				str += "</tr>"
			})// each
			
			str += "</table>"
			$("#result").html(str)
			$(".cntSpan").text(resp.count)
			
			})// getJSON
	}// init
	
	$("#commentBtn").click(function() {

		if ($("#comment").val() == "") {
			alert("댓글을 입력하세요")
			return;
		}

		$.ajax({

			type : "post",
			url : "commentInsert",
			data : {
				"msg" : $("#msg").val(),
				"bnum" : $("#bnum").val()
			}
		})//ajax
		.done(function(resp) {
			if (resp.trim() == 1) {
				alert("로그인하세요")
				location.href = "../member/login"
			} else {
				/* alert("성공") */
				init()
			}
		})///done
		.fail(function(e) {
			alert("error : " + e)
		})// fail

	})
init()
</script> -->

<%@ include file="../include/footer.jsp"%>
