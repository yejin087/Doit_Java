<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Address Insert</title>

<script>

function zipfinder(){
	window.open("zipcheck.addr","","width=700 height=500");
}
</script>

</head>
<body>
	<a href="list.jsp">전체 보기</a>
	<form action="insert.addr" method="post">
		<table border="1">
			<thead>
				<tr>
					<th colspan="2">Servlet 주소 등록하기</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input id="zipcode" type="text" name="zipcode" >
						<input type="button" value ="검색" onclick="zipfinder()">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="2">
						<input id="addr" type="text" name="addr" size="50">
					</td>

				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input type="text" name="tel">
					</td>
				</tr>
				<tr>
					<td>
						<button>등록</button>
						<button>취소</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>