<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="update_avo" class="com.jqueryAddress.AddressVO"></jsp:useBean>
<jsp:setProperty property="*" name="update_avo"/>
 
 <%
 JAddressDAO dao = JAddressDAOImpl.getInstance();
 dao.update(update_avo);
 response.sendRedirect("list.jsp");
 %>
