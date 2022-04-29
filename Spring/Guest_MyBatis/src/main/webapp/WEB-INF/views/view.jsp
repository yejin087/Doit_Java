<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUEST VIEW</title>
</head>
<body>
	
	name = ${guest.name}
	<br>
	content = ${guest.content}
	<br>
	grade =${guest.grade}
	<br>
	created = ${guest.created}
	<br>
	ipaddr = ${guest.ipaddr}
	<br>

	<input type="submit" value="update" onclick="location.href='gupdate?num=${guest.num}'">
	<input type="submit" value="delete">
</body>
</html>