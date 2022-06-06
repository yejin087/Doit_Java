<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<script>
$(document).ready(function() {
	$("#writeBtn").click(function(){

	if (${empty sessionScope.sUser} ){
		alert("로그인한 사람만 작성 가능합니다.")
		location.href = "../member/login"
		return;
	}
	location.href = "write"
	

	})// writeBtn.click

})// document
</script>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2>
				게시글 목록 (<span id="cntSpan">${count}</span>)
			</h2>
		</div>
	</div>
	<div class="container mt-5">
		<div class="mb-3">
			<button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${board_arr}" var="board" varStatus="status">
					<tr>
						<td>${rowNo-status.index}</td>
						<td>${board.userid}</td>
						<td>
							<a href="boardDetail?num=${board.num}">${board.subject}</a>
						</td>
						<td>${board.readcount}</td>
						<td>${board.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<ul class="pagination">
			<c:if test="${p.startPage > p.blockPage}">
				<li class="page-item disabled"><a class="page-link" href="boardlist?pageNum=${p.startPage-p.blockPage}&field=${p.field}&word=${p.word}">Previous</a></li>
			</c:if>
			<c:forEach begin="${p.startPage}" end="${p.endPage}" var="i">
				<!-- 현재 페이지가 아니면  -->

				<c:if test="${p.currentPage != i}">
					<li class="page-item"><a class="page-link" href="boardlist?pageNum=${i}&field=${p.field}&word=${p.word}">${i}</a></li>
				</c:if>
				<!-- 현재 페이지라면  -->
				<c:if test="${p.currentPage == i}">
					<li class="page-item"><a class="page-link">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${p.endPage < p.totPage}">

				<li class="page-item"><a class="page-link" href="boardlist?pageNum=${p.endPage+1}&field=${p.field}&word=${p.word}">Next</a></li>
			</c:if>
		</ul>
		<form action="boardlist" class="form-inline">
			<div class="form-group">
				<select class="form-control" id="field" name="field">
					<option value="subject">제목</option>
					<option value="content">내용</option>
					<option value="userid">작성자</option>
				</select>
				<input type="text" class="form-control" id="word" name="word" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-success">Search</button>
		</form>
	</div>
</body>
<%@ include file="../include/footer.jsp"%>