<%@page import="com.board.dto.CommentDTO"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String sid = (String) session.getAttribute("sUserid");

String msg = request.getParameter("msg");
int bnum = Integer.parseInt(request.getParameter("num"));

if (sid == null) {
	out.println("1");
} else {
	BoardDAO dao = BoardDAO.getInstance();
	CommentDTO comment = new CommentDTO();
	comment.setBnum(bnum);
	comment.setUserid(sid); // 로그인된 아이디
	comment.setMsg(msg);
	dao.commentInsert(comment);
}
%>