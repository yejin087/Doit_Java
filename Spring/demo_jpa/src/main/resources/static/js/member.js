$(document).ready(function() {


	$("#btnUpdate").click(function() {
		var dataParam = {
			"id": $("#id").val(),
			"name": $("#name").val(),
			"password": $("#password").val(),
			"addr": $("#addr").val(),
			"memo": $("#memo").val()
		}

		$.ajax({
			type: "put",
			url: "/update/",
			data: JSON.stringify(dataParam),
			contentType: "application/json;charset=utf-8"
		})
			.done(function() {
				alert("success update")
				location.href = "/list"
			})
			.fail(function() {
				alert("fail update")
			})

	})// btnUpdate
})// ready