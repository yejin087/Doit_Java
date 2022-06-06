<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update form</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/member.js"></script> 
<body>
	
	id :
	<input type="text" name="id"  id ="id" value="${member.id}" readonly>
	<br>
	Name :
	<input type="text" name="name" id="name" value="${member.name }">
	<br>
	Password:
	<input type="password" name="password" id="password">
	<br>
	Email :
	<input type="text" name="email" id="email" value="${member.email }">
	<br>
	Addr :
	<input type="text" name="addr" id="addr" value="${member.addr}">
	<br>
	Memo :
	<textarea rows="5" cols="50" id="memo" name="memo">${member.memo}</textarea>
	<br>
	<button type="button" id="btnUpdate">update</button>

</body>
</html>