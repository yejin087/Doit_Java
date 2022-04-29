<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Guest Home</title>
</head>
<body>

	<form action="ginsert" method="post">
		<input type="hidden" name="ipaddr" value="123.123">
		<table>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>평가</td>
				<td>
					<input type="radio" name="grade" value="excellent"> 아주 잘함(excellent) 
					<input type="radio" name="grade" value="good"> 잘함(good) 
					<input type="radio" name="grade" value="normal"> 보통(normal) 
					<input type="radio" name="grade" value="fail"> 노력(fail)
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>

</html>
