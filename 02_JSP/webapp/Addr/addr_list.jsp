<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>LIST</title>

<script type="text/javascript">
	function searchCheck() {
		if (document.getElementById("word").value == "") {
			alert("검색어를 입력하세요");
			document.getElementById("word").focus();
			return;
		}

		document.getElementById("sfrm").submit();
	}
</script>
</head>

<body>

	<div class="container">
		<div align="right">
			<a href="insert.addr">추가하기</a>/ <a href="list.addr"> 전체보기</a>
		</div>
		<h2>전체 보기 (${count})</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>우편 번호</th>
					<th>주소</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${a_addr}" var="adr">
					<tr>
						<td>${adr.num}</td>
						<td><a href="view.addr?num=${adr.num}">${adr.name}</a></td>
						<td>${adr.zipcode}</td>
						<td>${adr.addr}</td>
						<td>${adr.tel}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="list.addr" id="sfrm">
			<select name="field">
				<option value="name">이름</option>
				<option value="tel">전화번호</option>
			</select>
			<input id="word" type="text" name="word">
			<input type="button" value="검색" onclick="searchCheck()">
		</form>
	</div>
</body>
</html>