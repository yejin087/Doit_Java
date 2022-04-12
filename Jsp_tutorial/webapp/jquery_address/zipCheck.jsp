<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("#send").click(function() {
					$.getJSON("zipProcess.jsp", {
						"dong" : $("#dong").val()
					}, function(resp) {
						var str = "<table>"
						$.each(resp, function(key, val) {
							str += "<tr>"
							str += "<td>" + val.zipcode + "</td>"
							str += "<td>" + val.sido + "</td>"
							str += "<td>" + val.gugun + "</td>"
							str += "<td>" + val.dong + "</td>"
							str += "<td>" + val.bunji + "</td>"
							str += "<tr>"
						})// each
						str += "</table>"
						$("#result").html(str) // zipCheck.jsp 화면 아래 주소록 출력
					}// function
					)//.get
				})// send.click

				// 검색된 주소록 클릭시 이전 창에 zipcode, address 전달
				$("#result").on(
						"click",
						"tr",
						function() {
							var address = $("td:eq(1)", this).text() + " "
									+ $("td:eq(2)", this).text() + " "
									+ $("td:eq(3)", this).text() + " "
									+ $("td:eq(4)", this).text();

							$(opener.document).find("#zipcode").val(
									$("td:eq(0)", this).text());
							$(opener.document).find("#addr").val(address);
							self.close();
						}// function
				)// result.on
			})// document
</script>

</head>

<body>
	<table>
		<thead>
			<tr>
				<td>
					동 이름 입력:
					<input id="dong" type="text" name="dong">
					<input id="send" type="button" value="검색">
				</td>
			</tr>
		</thead>
	</table>
	<div id="result"></div>
</body>
</html>