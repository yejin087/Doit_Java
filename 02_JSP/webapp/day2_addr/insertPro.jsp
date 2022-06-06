<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--값을 가져와서 DB에 넣는다 -->

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="ad" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="ad"></jsp:setProperty>

<%
AddressDAO dao = AddressDAO.getInstance();
dao.addrInsert(ad);
response.sendRedirect("list.jsp");
%>

