<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
</head>
<body>

id : ${member.id} <br>
name : ${member.name} <br>
addr : ${member.addr} <br> 
email : ${member.email} <br>
memo : ${member.memo} 
<a href="/update/${member.id}">update member</a>
</body>
</html>