<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>

<body>

	<h3>Person View</h3>

	name : ${person.name }
	<br>
	id : ${person.id}
	<br>
	gender : ${person.gender }
	<br>
	job :${person.job}
	<br>


	<input type="button" value="수정" onclick="location.href='person_updateForm.go?id=${person.id}'">
	<input type="button" value="삭제" onclick="location.href='person_delete.go?id=${person.id}'">
	


</body>
</html>