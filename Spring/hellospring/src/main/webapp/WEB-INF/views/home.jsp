<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container mt-5">
	<h3>HOME</h3>

	<c:if test="${principal.member.role == 'ROLE_ADMIN' }">
		${principal.username} 관리자님 반갑습니다
	</c:if>
	
	<c:if test="${principal.member.role == 'ROLE_USER' }">
		${principal.username}님 반갑습니다
	</c:if>
</div>