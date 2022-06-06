<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="com.member.dto.MemberDTO" />
<jsp:setProperty name="member" property="*" />

<%
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memeberUpdate(member);
session.invalidate();
response.sendRedirect("loginForm.jsp");
%>