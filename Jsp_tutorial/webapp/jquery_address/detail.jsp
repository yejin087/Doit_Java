<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@page import="com.jqueryAddress.AddressVO"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQUERY DETAIL</title>
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));
JAddressDAO dao = JAddressDAOImpl.getInstance();
AddressVO avo = dao.findByNum(num);
%>
<script>
	function zipfinder() {
		window.open("zipCheck.jsp", "", "width=700 height=500");
	}
	
	function del(){
		//flag = confirm("정말 삭제할 까요?"); // 확인, 취소 알림 창 return ture, false
		if( confirm("정말 삭제할 까요?")){
			location.href="deleteProcess.jsp?num=<%=num%>";
		}

	}
</script>
<body>
	<form action="UpdateProcess.jsp">
		<input type="hidden" name="num" value="<%=avo.getNum()%>">
		<table>
			<caption>상세보기</caption>
			<thead>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" value="<%=avo.getName()%>">
					</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input id="zipcode" type="text" name="zipcode" size=10 value="<%=avo.getZipcode()%>">
						<input type="button" value="검색" onclick="zipfinder()">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input id="addr" type="text" name="addr" value="<%=avo.getAddr()%>" size="70">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="tel" value="<%=avo.getTel()%>">
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="reset" value="수정 취소">
						<input type="button" value="삭제" onclick="del()">
						<input type="button" value="전체보기" onclick="list_fun()">
						<input type="button" value="전체보기2" onclick="location.href = 'list.jsp'">
					</td>
				</tr>

			</thead>
		</table>
	</form>

</body>
</html>