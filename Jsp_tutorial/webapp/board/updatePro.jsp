<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="com.board.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty name="board" property="*" />

<%
BoardDAO dao = BoardDAO.getInstance();
int flag = dao.boardUpdate(board); // 1:성공 0:실패(비밀번호 틀렸다) 
board.setIp(request.getRemoteAddr());
if (flag == 1) {
	response.sendRedirect("list.jsp");
} else {
%>

<script>
	alert("비밀번호가 일치 하지 않습니다.");
	history.back(); // 이전 페이지로 이동
</script>
<%
}
%>