<%@page import="com.address.Zipcode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("utf-8");
String dong = request.getParameter("dong");
AddressDAO dao = AddressDAO.getInstance();
ArrayList<Zipcode> z_arr = dao.zipcodeRead(dong);
%>
<style type="text/css">
a:link {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}

a:visited {
	text-decoration: none;
	color: black;
}
</style>

<script>
	function dongCheck() {
		if (document.getElementById("dong").value == "") {
			alert("동 이름을 입력하세요")
			document.getElementById("dong").focus();
			return; // dongCheck() 함수 종료?
		}

		document.getElementById("frm").submit();
	}
	function send(code, sido, gugun, doong, bunji) {
		const address = sido + " " + gugun + " " + doong + " " + bunji;
		opener.document.getElementById("zipcode").value = code;
		opener.document.getElementById("addr").value = address;
		self.close();
	}
</script>

</head>
<body>
	<form id="frm" action="zipCheck.jsp">
		<table>
			<caption>우편 번호 찾기</caption>
			<thead>
				<tr>
					<td>
						동 이름 입력:
						<input id="dong" type="text" name="dong">
						<input type="button" value="검색" onclick="dongCheck()">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<%
					if (z_arr.isEmpty()) {
					%>
					<td>검색 결과가 없습니다.</td>
					<%
					} else {
					%>
					<td>우편 번호를 클릭하면 자동으로 입력 됩니다.</td>
					<%
					}
					%>
				</tr>
				<%
				for (Zipcode z : z_arr) {
					String zip = z.getZipcode();
					String sido = z.getSido();
					String bunji = z.getBunji();
					String doong = z.getDong();
					String gugun = z.getGugun();
				%>
				<tr>
					<td>
						<a href="javascript:send('<%=zip%>','<%=sido%>','<%=gugun%>','<%=doong%>','<%=bunji%>')">
						 <%=zip%> <%=sido%> <%=gugun%> <%=doong%> <%=bunji%></a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>