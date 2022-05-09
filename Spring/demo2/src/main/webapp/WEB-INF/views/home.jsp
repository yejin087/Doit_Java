<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<sec:authorize access="isAnonymous()"> <a href="login">login</a> </sec:authorize>

<sec:authorize access="isAuthenticated()">
principal : <sec:authentication property="principal" /> <br>
authentication : <sec:authentication property="principal.member"/> <br>
name : <sec:authentication property="principal.member.username"/> <br>
id : <sec:authentication property="principal.username"/> <br>
<a href ="logout">logout</a>
</sec:authorize>

</body>
</html>