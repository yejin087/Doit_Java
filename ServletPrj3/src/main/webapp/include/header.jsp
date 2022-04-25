<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>header</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- 두 개의 네비 블럭을 담은 div  -->
		<div class="container">
			<!-- 왼쪽 네비 블럭 -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="navbar-brand" href="#">HOME</a></li>
				<li class="nav-item"><a class="nav-link" href="../board/boardlist">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="../product/plist">상품보기</a></li>
			</ul>
			<!-- 오른쪽 네비 블럭 -->
			<ul class="navbar-nav">
				<c:if test="${empty sessionScope.sUser}">
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/member/join">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/member/login">로그인</a></li>
				</c:if>

				<c:if test="${not empty sessionScope.sUser}">
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/member/logout">로그 아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/member/update">회원 변경</a></li>

				</c:if>
				<!--관리자 -->
				<c:if test="${sessionScope.sUser.admin == 1}">
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/member/memberlist">회원 목록</a></li>
					<li class="nav-item"><a class="nav-link" href="/ServletPrj3/product/pInsert">상품등록</a></li>
					<span class="navbar-text">/ (${sessionScope.sUser.name})(관리자)님 반갑습니다</span>
				</c:if>

				<!--일반 회원 -->
				<c:if test="${sessionScope.sUser.admin == 0}">
					<span class="navbar-text">(${sessionScope.sUser.name})님 반갑습니다</span>
				</c:if>
			</ul>
		</div>
	</nav>


</body>
</html>