<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>게시글 목록(${count})</h2>
	</div>
</div>
<div class="container mt-5">
	<table class="table table-hover">
		<thead>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${board_list}" var="board" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td><a href="view/${board.num}" name="num"> ${board.title} </a></td>

					<td>${board.writer}</td>

					<td>${board.content}</td>

					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>

					<td>${board.hitcount}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</div>
