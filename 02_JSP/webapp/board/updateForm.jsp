<%@page import="com.board.dto.BoardDTO"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));
BoardDAO dao = BoardDAO.getInstance();
BoardDTO board = dao.findByNum(num);
%>
<body>
	<h2>글 수정하기</h2>
	<form action="updatePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=board.getNum()%>">
		<table border="1">
			<thead>
				<tr>
					<th colspan=3 align="right"><a href="">글 목록</a></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="writer" size="20" value="<%=board.getWriter()%>">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name=subject size="20" value="<%=board.getSubject()%>">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" size="20" value="<%=board.getEmail()%>">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea id="content" name="content" rows="10" cols="50"><%=board.getContent()%>"</textarea>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="text" name="passwd" size="20">
					</td>
				</tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>