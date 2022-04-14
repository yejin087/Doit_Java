<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
// form으로 전달 받지 않았으므로 session.getAttribute 사용
String userid = (String)session.getAttribute("sUserid");
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memeberDelete(userid);
response.sendRedirect("loginForm.jsp");
%>