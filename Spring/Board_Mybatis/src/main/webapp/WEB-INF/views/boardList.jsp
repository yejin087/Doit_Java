<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>게시글 목록 (${count})</h2>
	</div>
</div>
<div class="container mt-5">
	<table class="table table-hover">
		<thead>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		<tbody>
			<c:forEach items="${board_list}" var="board">
				<tr>
					<td><a href="view/${board.num}" name="num"> ${board.title}</a></td>

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
			<li class="page-item">
			<c:if test="${p.startPage > p.blockPage}">
					<a class="page-link" href="list?pageNum=${p.startPage-p.blockPage}&field=${param.field}&word=${param.word}">prev</a>
				</c:if>
			</li>

			<c:forEach begin="${p.startPage}" end="${p.endPage}" var="i">

				<!-- other page -->
				<c:if test="${p.currentPage != i}">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${i}&field=${param.field}&word=${param.word}">${i}</a>
						<%-- <a class="page-link" href="list?pageNum=${i}&field=${p.field}&word=${p.word}">${i}</a> --%>
					</li>
				</c:if>

				<!-- current page  -->
				<c:if test="${p.currentPage == i}">
					<li class="page-item active">
						<a class="page-link">${i}</a>
					</li>
				</c:if>
			</c:forEach>

			<c:if test="${p.endPage < p.totPage}">
				<li class="page-item">
					<a class="page-link" href="list?pageNum=${p.endPage+1}&field=${param.field}&word=${param.word}">next</a>
				</li>
			</c:if>

		</ul>



		<form class="form-inline" action="/board/list" id="searchForm">
			<select id="field" name="field" class="form-control mr-sm-1">
				<option value="writer">writer</option>
				<option value="content">content</option>
			</select>
			<input type="text" id="word" name="word" class="form-control">
			<button class="btn btn-secondary">Search</button>
		</form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>