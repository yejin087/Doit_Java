<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="container">
	<h3 class="mt-3">Board List(${count})</h3>
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
			<c:forEach items="${board_list.content}" var="board" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td><a href="/board/view/${board.num}" name="num"> ${board.title}</a></td>

					<td>${board.writer}</td>

					<td>${board.content}</td>

					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>

					<td>${board.hitcount}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<div class="d-flex justify-content-between mt-5">
		<ul class="pagination">
			<c:if test="${board_list.first==false}">
				<li class="page-item">
					<a href="?page=${board_list.number-1}">prev</a>
				</li>
			</c:if>
			<li class="page-item">[${board_list.number +1}]</li>
			<c:if test="${board_list.last==false}">
				<li class="page-item">
					<a href="?page=${board_list.number+1}">next</a>

				</li>
			</c:if>
		</ul>
	</div>