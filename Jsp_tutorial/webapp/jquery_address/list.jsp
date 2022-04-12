<%@page import="com.jqueryAddress.AddressVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">

<title>JQUERY LIST</title>

</head>
<script>
	$(document).ready(
			function() {
				$("#btnSearch").click(
						function() {
							$.ajax({
								type : "get",
								url : "searchProcess.jsp",
								data : {
									"field" : $("#field").val(),
									"word" : $("#word").val()
								},
								success : function(resp) {
									// 성공시 돌아오는 검색 결과 값을 처리한다.
									// json 형태로 변환되어서 받아야한다.
									var json_parse = JSON.parse(resp);
									var str = "";

									// jsonarr을 반복문 돌린다.
									$.each(json_parse.jsonarr, function(key,
											val) {
										str += "<tr>"
										str += "<td>" + val.num + "</td>"
										str += "<td> <a href= 'detail.jsp?num="
												+ val.num + "'>" + val.name
												+ "</a> </td>"

										str += "<td>" + val.zipcode + "</td>"
										str += "<td>" + val.addr + "</td>"
										str += "<td>" + val.tel + "</td>"
										str += "<tr>"
									})// each

									$("table tbody").html(str);

									$("h2 span").text(json_parse.countObj.count);

								},
								error : function(e) {
									alert("error : " + e);
								}
							})//ajax
						})// btnSearch.click
			})// document.ready
</script>

<%
JAddressDAOImpl dao = new JAddressDAOImpl();
ArrayList<AddressVO> a_avo = dao.list();
int count = dao.getCount();
%>

<body>
	<div class="container">
		<div align="right">
			<a href="insert.jsp">추가하기</a>/ <a href="list.jsp"> 전체보기</a>
		</div>
		<h2>
			전체 보기 (<span><%=dao.getCount()%></span>)
		</h2>
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
				<%
				for (AddressVO ad : a_avo) {
				%>
				<tr>
					<td><%=ad.getNum()%></td>
					<td>
						<a href="detail.jsp?num=<%=ad.getNum()%>"> <%=ad.getName()%></a>
					</td>
					<td><%=ad.getZipcode()%></td>
					<td><%=ad.getAddr()%></td>
					<td><%=ad.getTel()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<select id="field" name="field">
			<option value="name">이름</option>
			<option value="tel">전화번호</option>
		</select>
		<input id="word" type="text" name="word">
		<input id="btnSearch" type="button" value="검색">

	</div>
</body>
</html>