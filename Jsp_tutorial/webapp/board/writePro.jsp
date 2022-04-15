<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="com.board.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty name="board" property="*"/>

<%
BoardDAO dao = BoardDAO.getInstance();
dao.boardInsert(board); // 새글 또는 댓글을 추가한다.
response.sendRedirect("list.jsp");
%>