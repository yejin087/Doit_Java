<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest List</title>
</head>
<body>
	<h3>Guest List (${count})</h3>
	<c:forEach items="${guestlist }" var="guest">
		name = <a href="gview?num=${guest.num}"> ${guest.name} </a>
		<br>
		content = ${guest.content} <br>
		grade =${guest.grade} <br>
		created = ${guest.created} <br>
		ipaddr = ${guest.ipaddr} <br>
		<hr>
	</c:forEach>
	<form action="glist">

		<select name="field">
			<option value="name">이름</option>
			<option value="job">내용</option>
		</select>
		<input type="text" name="word">
		<input type="submit" value="검색">
	</form>
</body>
</html>