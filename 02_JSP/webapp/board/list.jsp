<%@page import="com.board.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<%
request.setCharacterEncoding("utf-8");

String pageNum = request.getParameter("pageNum");
// pageNum이 아무것도 없다면 초기값 1
if (pageNum == null) {
	pageNum = "1";
}

String field = "";
String word = "";
if (request.getParameter("word") != null) {
	field = request.getParameter("field");
	word = request.getParameter("word");
}

int curPage = Integer.parseInt(pageNum); // 현재 페이지 번호
int pageSize = 5; // 한 화면에 보여줄 게시물 수 
int startRow = (curPage - 1) * pageSize + 1; // 페이지에 보여줄 게시글 시작 번호
int endRow = curPage * pageSize; // 페이지에 보여줄 게시글 마지막 번호

BoardDAO dao = BoardDAO.getInstance();
// start~end 만큼의 게시글을 가지고 온다.
ArrayList<BoardDTO> a_board = dao.boardList(field, word, startRow, endRow);
int count = dao.getCount(field, word);
%>
<body>
	<div align="left">
		<a href="writeForm.jsp">글 쓰기</a>
	</div>
	<h2>
		게시글 목록 (<%=count%>)
	</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BoardDTO board : a_board) {
			%>
			<tr>
				<td><%=board.getNum()%></td>
				<td>
					<a href="boardView.jsp?num=<%=board.getNum()%>"><%=board.getSubject()%></a>
				</td>
				<td><%=board.getWriter()%></td>
				<td><%=board.getReg_date()%></td>
				<td><%=board.getReadcount()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<form action="list.jsp" name="search" method="get">
		<select name="field">
			<option value="subject">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" size=16 name="word">
		<input type="submit" value="찾기">
	</form>

	<div align="center">
		<%
		// 화면에 보여줄 페이지 블럭 설정
		// 게시글이 있는 경우
		if (count > 0) {
			// 총 페이지 수
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			// 한번에 보여줄 페이지 수
			int pageBlock = 3;
			// 화면에 보여주는 페이지 시작 번호
			int startPage = (int) ((curPage - 1) / pageBlock) * pageBlock + 1;
			// 화면에 보여주는 페이지 마지막 번호
			int endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) {
				endPage = pageCount;
			}

			//이전 버튼
			if (startPage > pageBlock) {
				%>
				<a href="list.jsp?pageNum=<%=startPage - pageBlock%>&field=<%=field%>&word=<%=word%>">[이전]</a>
				<%
			}
			
			//페이지 번호
			for (int i = startPage; i <= endPage; i++) {
				if (i == curPage) {
					%>
					[<%=i%>]
					<%
				} else {
					%>
					<a href="list.jsp?pageNum=<%=i%>&field=<%=field%>&word=<%=word%>"><%=i%></a>
					<%
				}
				
			} 
				
			//다음 버튼
			if (endPage < pageCount) {
				%>
				<a href="list.jsp?pageNum=<%=startPage + pageBlock%>&field=<%=field%>&word=<%=word%>">[다음]</a>
				<%
			}
		}
		%>
	</div>
</body>
</html>