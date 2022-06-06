$(document).ready(function() {
	
	var init = function() {
		$.getJSON("commentlist",
			{ "bnum": $("#bnum").val() },
			function(resp) {
				var str = "<table class='table table-hover'>"

				$.each(resp.jarr, function(key, val) {
					str += "<tr>"
					str += "<td>" + val.msg + "</td>"
					str += "<td>" + val.userid + "</td>"
					str += "<td>" + val.regdate + "</td>"
					str += "</tr>"
				})// each

				str += "</table>"
				$("#result").html(str)
				$(".cntSpan").text(resp.count)

			})// getJSON
	}// init

	$("#commentBtn").click(function() {

		if ($("#comment").val() == "") {
			alert("댓글을 입력하세요")
			return;
		}

		$.ajax({

			type: "post",
			url: "commentInsert",
			data: {
				"msg": $("#msg").val(),
				"bnum": $("#bnum").val()
			}
		})//ajax
			.done(function(resp) {
				if (resp.trim() == 1) {
					alert("로그인하세요")
					location.href = "../member/login"
				} else {
					/* alert("성공") */
					init()
					$("#msg").val("")
				}
			})///done
			.fail(function(e) {
				alert("error : " + e)
			})// fail

	})
	
	init()

})// document