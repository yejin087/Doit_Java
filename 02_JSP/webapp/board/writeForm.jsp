<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE FORM</title>
</head>
<%
request.setCharacterEncoding("utf-8");
int num = 0;
int ref = 1;
int re_step = 0;
int re_level = 0;
if (request.getParameter("num") != null) { // 답글인 경우 가지고 오는 num이 존재한다

	num = Integer.parseInt(request.getParameter("num"));
	ref = Integer.parseInt(request.getParameter("ref"));
	re_step = Integer.parseInt(request.getParameter("re_step"));
	re_level = Integer.parseInt(request.getParameter("re_level"));
}
%>
<body>
	<h1>글 쓰기</h1>
	<form action="writePro.jsp" method="post">
		<!-- 답글일 경우 가지고 가야항 값 -->
		<input type="hidden" name="num" value=<%=num%>>
		<input type="hidden" name="num" value=<%=ref%>>
		<input type="hidden" name="num" value=<%=re_step%>>
		<input type="hidden" name="num" value=<%=re_level%>>
		<table border="1">
			<thead>
				<tr>
					<th colspan=3 align="right"><a href="list.jsp">글 목록</a></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="writer" size="20">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<%
						if (request.getParameter("num") != null) {
						%>
						<input type="text" name="subject" value="[답글]">
						<%
						} else {
						%>
						<input type="text" name=subject size="20">
						<%
						}
						%>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" size="20">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea id="content" name="content" rows="10" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="text" name="passwd" size="20">
					</td>
				</tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>