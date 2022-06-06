<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h2>상품 상세</h2>
	</div>
</div>


<div class="d-flex container">

	<div class="card" style="width: 400px">
		<img class="card-img-top" src="../upload/${p_detail.filename}" class="rounded" alt="Img">
	</div>
	<div class="container">
		<table class="table table-boarerless">

			<tr>
				<th>상품 아이디</th>
				<td>${p_detail.productId }</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>${p_detail.pname}</td>
				<th>상태</th>
				<td>${p_detail.condition}</td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td>${p_detail.unitPrice }</td>
				<th>분류</th>
				<td>${p_detail.category}</td>
			</tr>
			<tr>
				<th>재고 수</th>
				<td>${p_detail.unitInStock }</td>
				<th>제조사</th>
				<td>${p_detail.manufacturer }</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td colspan="3">${p_detail.description }</td>
			</tr>
		</table>
		<div>
			<a class="btn btn-secondary" href="#">장바구니</a>
			<a class="btn btn-primary" href="#">구매하기</a>
		</div>
	</div>


</div>



<%@ include file="../include/footer.jsp"%>
