<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>Board Detail</h2>
	</div>
</div>
<sec:authentication property="principal" var="info" />

<sec:authorize access="isAuthenticated()">
	<input type="hidden" id="prin" name="prin" value="${info.username}" />
</sec:authorize>
<sec:authorize access="isAnonymous()">
	<input type="hidden" id="prin" name="prin" value="null">
</sec:authorize>

<div class="container mt-5">
	<div class="d-flex justify-content-between">
		<input type="hidden" id="bnum" value="${board.num}">
		<h3>No.${board.num } ${board.title }</h3>
		<div class="d-flex">
			<p id="writer">작성자 : ${board.writer}</p>
			<p>| 작성일 ${board.regdate }</p>
			<p>| 조회수 ${board.hitcount }</p>
		</div>
	</div>
	<hr>
	<div>${board.content }</div>
	<hr>

	<div class="d-flex">
		<div class="form-group">
			<sec:authorize access="isAuthenticated()">
				<%-- <c:if test="${board.writer} == <sec:authentication property='principal.username'/>"> --%>
				<c:if test="${info.username == board.writer}">
					<button type="button" class="btn btn-secondary btn-sm" id="btnUpdateForm">Update</button>
					<button type="button" class="btn btn-danger btn-sm" id="btnDelete">Delete</button>
				</c:if>
			</sec:authorize>
			<button type="button" class="btn btn-dark btn-sm" id="btnList" onclick="location.href='../list'">List</button>
		</div>
	</div>

	<textarea rows="3" cols="50" id="msg"></textarea>
	<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>

	<p>댓글 목록</p>
	<div id="commentList" class="mt-6"></div>
</div>

<script>
	commentLoad = function() {
		$.ajax({
			type : "get",
			url : "/mysecurity/reply/commentList/${board.num}"
		}).done(
				function(resp) {
					var str = "<table class='table'>"
					$.each(resp, function(index, val) {
						str += "<tr>"
						str += "<td>" + val.userid + "</td>"
						str += "<td>" + val.content + "</td>"
						str += "<td>" + val.regdate + "</td>"
						if ($("#prin").val() == val.userid) {
							str += "<td>" + "<a href='javascript:commentDel("
									+ val.cnum + ")'> 삭제 </a>" + "</td>"
						}
					})
					str += "</table>"
					$("#commentList").html(str)
				}).fail(function(e) {
			alert("fail " + e)
		})
	}

	$("#btnComment").click(function() {

		if ($("#prin").val() == "null") {
			alert("로그인하세요")
			location.href = "/mysecurity/customLogin"
			return;
		}

		if ($("#msg").val() == "") {
			alert("댓글을 입력하세요")
			return;
		}

		var postData = {
			"content" : $("#msg").val(),
			"bnum" : $("#bnum").val(),
			"userid" : $("#prin").val()
		}

		$.ajax({
			type : "post",
			url : "/mysecurity/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(postData)
		})// ajax
		.done(function(resp) {
			if (resp == "success") {
				alert("댓글 추가 성공")
				commentLoad()
			}

		}).fail(function(e) {
			alert("댓글 추가 실패 : " + e)
		})

	})// btnComment.click

	function commentDel(cnum) {

		$.ajax({
			type : "delete",
			url : "/mysecurity/reply/commentDelete/" + cnum
		}).done(function(resp) {
			alert(resp + "번글 삭제 성공")
			commentLoad()
		}).fail(function(e) {
			alert("error " + e)
		})

	}
	commentLoad()
</script>
