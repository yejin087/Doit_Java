$(document).ready(function() {

	$("#sendBtn").on("click", function() {

		if ($("#name").val() == "") {
			alert("이름을 입력하세요")
			$("#name").focus()
			return;
		}

		if ($("#userid").val() == "") {
			alert("userid를 입력하세요")
			$("#userid").focus()
			return;
		}


		if ($("#email").val() == "") {
			alert("이메일을 입력하세요")
			$("#email").focus()
			return;
		}

		/*	var email_exp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if (!$("#email").val().match(email_exp)) {
				alert("이메일 형식에 맞지 않습니다.")
				$("#email").focus()
				return;
			}*/

		if ($("#pwd").val() == "") {
			alert("비밀번호를 입력하세요")
			$("#pwd").focus()
			return;
		}

		if ($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다.")
			$("#pwd_check").focus()
			return;
		}

		var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/
		if (!$("#phone").val().match(exp)) {
			alert("전화번호 양식은 010-0000-000 입니다.")
			$("#phone").focus()
			return;
		}

		$("#frm").submit()
	})// sendBtn.on click

	$("#loginBtn").on("click", function() {

		if ($("#userid").val() == "") {
			alert("아이디를 입력하세요")
			return;
		}

		if ($("#pwd").val() == "") {
			alert("비밀번호를 입력하세요")
			return;
		}

		$.ajax({
			type: "post",
			url: "login",
			data: {
				"userid": $("#userid").val(),
				"pwd": $("#pwd").val()
			},
			success: function(resp) {
				// 0:일반회원
				// 1:관리자
				// 2:비번오류
				// -1:비회원

				if (resp.trim() == 0) {
					alert("일반회원 로그인")
					location.href ="../board/boardlist"
				} else if (resp.trim() == 1) {
					alert("관리자 로그인")
					location.href = "memberlist"
				} else if (resp.trim() == 2) {
					alert("비밀 번호 오류")
				} else if (resp.trim() == -1) {
					alert("회원이 아닙니다.")
				}
			},
			error: function(e) {
				alert("error : " + e)
			}
		})// ajax
	})// loginBtn.on


	// 아이디 중복 확인 창
	$("#idCheckBtn").click(function() {
		window.open("idCheck", "", "width=500 height=200");
	})//idCheck

	// 아이디 중복확인
	$("#useBtn").click(function() {
		if ($("#userid").val() == "") {
			alert("아이디를 입력하세요")
			return;
		}

		$.ajax({
			type: "post",
			url: "idCheck",
			data: {
				"userid": $("#userid").val()
			},
			success: function(resp) {

				if (resp.trim() == "YES") {
					// 사용 가능	
					$(opener.document).find("#userid").val($("#userid").val())
					self.close()
				} else {
					// 사용 불가능
					alert("사용불가능한 아이디입니다.")
					$("#userid").val("")
					$("#userid").focus()
				}
			}
		})// ajax
	})//useBtn.click
})// document

function del(userid) {
	if (confirm("정말 삭제할까요?")) {
		$.getJSON("userDelete",
			{ "userid": userid },
			function(resp) {
				var str = "";
				$.each(resp.mem_arr, function(key, val) {
					str += "<tr>"
					str += "<td>" + val.name + "</td>"
					str += "<td>" + val.userid + "</td>"
					str += "<td>" + val.tel + "</td>"
					str += "<td>" + val.email + "</td>"
					if (val.admin == 0) {
						str += "<td>일반회원</td>"
						str += "<td onclick=del('"+val.userid+"')>삭제</td>"
					} else {
						str += "<td>Admin</td>"
					}
					str += "</tr>"
				}
				)// each
				$("table tbody").html(str);
				$("#cntSpan").text(resp.count);
			}
		)// getJSON
	}// if
}// del