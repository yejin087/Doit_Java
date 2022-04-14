$(document).ready(function() {

	var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/ // 전화번호 정규표현식
	$("#sendBtn").click(function() {

		if ($("#name").val() == "") {
			alert("이름 입력");
			$("#name").focus();
			return;
		}

		if ($("#userid").val() == "") {
			alert("userid 입력");
			$("#userid").focus();
			return;
		}

		if ($("#email").val() == "") {
			alert("이메일 입력");
			$("#email").focus();
			return;
		}

		if ($("#pwd").val() == "") {
			alert("비밀번호 입력");
			$("#pwd").focus();
			return;
		}

		if ($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return;
		}
		/*
				if ($("#phone").val() == "") {
					alert("전화번호 입력");
					$("#phone").focus();
					return;
				}
		*/

		//전화번호 양식 검사
		if (!$("#phone").val().match(exp)) {
			alert("전화번호 형식이 아닙니다.")
			$("#phone").focus();
			return;
		}
		/*
		if(exp.text($("#phone").val())){
				alert("전화번호 패턴이 아닙니다.");
				$("#phone").focus();
				return;
		}
		*/
		$("#frm").submit();
	});// sendBtn.click

	//아이디 중복 확인 창
	$("#idCheckBtn").click(function() {
		window.open("idCheck.jsp", "", "width=600 height=300");
	})// idcheckbtn.click

	//아이디 중복확인
	$("#idUseBtn").click(function() {
		if ($("#userid").val() == "") {
			$("#userid").focus();
			return;
		}

		$.ajax({
			type: "post",
			url: "idCheckPro.jsp",
			data: {
				"userid": $("#userid").val()
			},
			success: function(resp) {

				if (resp.trim() == "NO") {
					alert("사용 불가능한 아이디 입니다.");
					$("#userid").val("");
					$("#userid").focus();
				}
				else{
					alert("사용가능한 아이디 입니다.")
					$(opener.document).find("#userid").val($("#userid").val());
					self.close();
				}
			},
			error: function(e) {
				alert("error : " + e);
			}
		})// ajax
	})// idusebtn.click

});// document

function del(userid, mode) {

	if (mode == '관리자') {
		alert("관리자는 삭제할 수 없습니다");
		return;
	}

	if (confirm("삭제할까요?")) {

		$.getJSON("memberDeletePro.jsp",
			{
				"userid": userid
			},
			function(resp) {
				var str = "";
				$.each(resp.m_a_memObj, function(key, val) {
					str += "<tr>"
					str += "<td>" + val.name + "</td>"
					str += "<td>" + val.userid + "</td>"
					str += "<td>" + val.tel + "</td>"
					str += "<td>" + val.email + "</td>"
					str += "<td>" + val.admin + "</td>"
					str += "<td><a href=javascript: del('" + val.userid + "' , '" + val.admin + "')>삭제</a></td>"
					str += "</tr>"
				}
				)// each
				$("table tbody").html(str);
				$("#cntSpan").text(resp.m_countObj.count);
			}
		)// getJSON
	}// if

}// del


