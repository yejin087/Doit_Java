<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="update" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="update"/>


<%
AddressDAO dao = AddressDAO.getInstance();
dao.addrUpdate(update);
response.sendRedirect("list.jsp");
%>