<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Zip Check</title>

<style type="text/css">
a:link {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}

a:visited {
	text-decoration: none;
	color: black;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		$("#send").on("click", function() {
			sendIt();
		})// send. on

		$("#result").on(
				"click",
				"tr",
				function() {
					var address = $("td:eq(1)", this).text() + " "
							+ $("td:eq(2)", this).text() + " "
							+ $("td:eq(3)", this).text() + " "
							+ $("td:eq(4)", this).text() + " "

					$(opener.document).find("#zipcode").val($("td:eq(0)", this).text());
					$(opener.document).find("#addr").val(address)
					self.close();
				})// result.on
				
		$("#dong").keydown(function(e){
			if( e.keyCode == 13){
				sendIt();
			}
		})// dong.keydown
	})// $function
	
	function sendIt(){
		if ($("#dong").val() == "") {
			alert("동이름을 입력하세요")
			return false
		}

		$.ajax({
			type : "post",
			url : "zipcheck.addr",
			data : {
				"dong" : $("#dong").val()
			}
		})// ajax
		.done(function(resp) {
			var str = "<table>"
			$.each(resp, function(key, val) {
				str += "<tr>"
				str += "<td>" + val.zipcode + "</td>"
				str += "<td>" + val.sido + "</td>";
				str += "<td>" + val.gugun + "</td>";
				str += "<td>" + val.dong + "</td>";
				str += "<td>" + val.bunji + "</td>";
			})
			str += "</table>"
			$("#result").html(str)
		})// done
		.fail(function(e) {
			alert("error" + e)
		})// fail
	}// sendIt
</script>
</head>
<body>

		<div>우편 번호 찾기</div>
		동 이름 입력:
		<input id="dong" type="text" name="dong">
		<input type="button" value="검색" id="send">

		<div id="result"></div>


</body>
</html>