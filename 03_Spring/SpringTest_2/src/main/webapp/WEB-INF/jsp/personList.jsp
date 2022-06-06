<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>person List (${count})</h3>
	<c:forEach items="${personlist}" var="person">
		id : <a href="person_view.go?id=${person.id}">${person.name}</a>
		<br>
		gender : ${person.gender}
		<br>
		job :${person.job}
		<br>
		<hr>
	</c:forEach>
</body>
</html>