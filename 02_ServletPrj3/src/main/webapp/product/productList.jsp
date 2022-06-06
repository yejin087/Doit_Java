<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>상품 목록</h1>
	</div>
</div>
<body>
	<div class="container">
		<div class="row h-100">
			<c:forEach items="${p_arr}" var="item">
				<div class="col-4 mb-3" style="width: 400px">
					<div class="card">
						<div class="embed-responsive embed-responsive-1by1">
							<img class="card-img-top embed-responsive-item" src="../upload/${item.filename}" alt="Card image" style="width: 100%">
						</div>
						<div class="card-body">
							<p class="card-text">${item.description}</p>
							<a class="btn btn-primary" href="pdetail?pid=${item.productId}">상세보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>

<%@ include file="../include/footer.jsp"%>
