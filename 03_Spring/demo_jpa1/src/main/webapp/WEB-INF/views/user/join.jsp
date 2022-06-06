<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<body>
	<div class="container">
		<h3 class="mt-3">JOIN</h3>


		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" class="form-control" id="username" placeholder="Enter userid" name="id">
		</div>


		<div class="form-group">
			<label for="password">Password:</label>
			<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>

		<div class="form-group">
			<label for="email">email:</label>
			<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>


		<br>
		<br>

		<button type="button" class="btn btn-secondary" id="btnJoin">create account</button>

	</div>
</body>

<script>

$("#btnJoin").click(function(){
	if($("#username").val() == ""){
		alert("enter id")
		$("#username").focus()
		return;
	}
	
	if( $("#password").val() == ""){
		alert("enter password")
		$("#password").focus()
		return;
	}
	
	if( $("#email").val() == ""){
		alert("enter email")
		$("#email").focus()
		return;
	}
	
	var regiStr = {
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()
	}
	
	$.ajax({
		type : "post",
		url : "register",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(regiStr)
	})
	.done(function(resp){
		if( resp == "success"){
			alert("success create account")			
		}
		else if( resp == "fail"){
			alert("ID duplicate")
			$("#username").val("")
			
		}
	})
	.fail(function(){
		alert("fail create account")
	})
	
})

</script>

