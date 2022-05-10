<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
 $(document).ready(function(){ 
	$("#memberDiv").on("click", ".btnDel", function(){

		$.ajax({
			type: "delete",
			url : "/delete/" + $(this).data("mid")
		})
		.done(function(resp){
			alert("success delete" + resp)
			location.href="/list"
		})
		.fail(function(e){
			alert("fail delete")
		})
		
	})// #memberDiv
 })// ready 
 
	function fDel(id){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		
		$.ajax({
			type: "delete",
			url : "/delete/" + id
		})
		.done(function(resp){
			alert("success delete" + resp)
			location.href="/list"
		})
		.fail(function(e){
			alert("fail delete")
		})
	}
</script>
<body>
	<div id="memberDiv">
		<c:forEach items="${lists.content}" var="member">
			<br> id : ${member.id} 
			<br> name : ${member.name} 
			<br> addr : ${member.addr} 
			<br> email : ${member.email}
			<a href="detail/${member.id}">member detail</a>
			<button type="button" onclick="fDel(${member.id})">delete by func</button>
			<button type="button" class="btnDel" data-mid="${member.id}">delete by Class</button>
			<br>
			<br>
		</c:forEach>
	</div>
	
	<a href="?page=${lists.number+1}">next</a>
	
	<c:choose>
	<c:when test="${lists.first}">
		[First]	
	</c:when>
	
	
	<c:when test="${lists.last}">	
		<a href="?page=${lists.number-1}">prev</a>
	</c:when>
	</c:choose>
</body>
</html>