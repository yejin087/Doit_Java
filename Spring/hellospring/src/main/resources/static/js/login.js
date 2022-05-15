$(document).ready(function () {

    $("#btnLogin").click(function () {

        if ($("#username").val() = "") {
            alert("아이디를 입력하세요")
            $("#username").focus()
            return;
        }

        if ($("#password").val() = "") {
            alert("비밀번호를 입력하세요")
            $("#password").focus()
            return;
        }

    })


})