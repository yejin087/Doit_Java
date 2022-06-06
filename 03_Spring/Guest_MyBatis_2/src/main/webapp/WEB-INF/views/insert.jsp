<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Guest Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/guest.js"></script>
<body>

	<form action="insert" method="post">
		<input type="hidden" name="ipaddr" value="123.123">
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><input id="name" type="text" name="name"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input id="content" type="text" name="content"></td>
			</tr>
			<tr>
				<td>평가</td>
				<td><input type="radio" name="grade" value="excellent"> 아주 잘함(excellent) <input type="radio" name="grade" value="good"> 잘함(good) <input type="radio" name="grade" value="normal"> 보통(normal) <input type="radio" name="grade" value="fail"> 노력(fail)</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="submit" id="send"></td>
			</tr>
		</table>

		<div align=" right">
			<select name="field" id="field">
				<option value="name">name</option>
				<option value="content">content</option>
			</select>
			<input type="text" name="word" id="word">
			<input type="button" value="search" id="btnSearch">
		</div>
	</form>
	<hr>
	<div id="cntDiv"></div>
	<hr>
	<div id="result"></div>
	<hr>
	<div id="viewDiv"></div>

</body>

</html>
