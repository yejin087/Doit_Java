<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>
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
			<c:if test="${board.writer} == <sec:authentication property='principal.username'/>">
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
