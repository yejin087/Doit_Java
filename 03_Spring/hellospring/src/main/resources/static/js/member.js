$(document).ready(function () {

    $("#btnUpdateAcc").click(function () {

        if ($("#password").val() == "") {
            alert("비밀번호를 입력하세요")
            $("#password").focus()
            return;
        }

        if ($("#passwordcheck").val() != $("#password").val()) {
            alert("비밀번호가 일치하지 않습니다")
            $("#password").val("")
            $("#passwordcheck").val("")
            $("#password").focus()
            return;
        }

        if ($("#email").val() == "") {
            alert("이메일을 입력하세요")
            $("#email").focus()
            return;
        }

        var putStr = {
            "username": $("#username").val(),
            "password": $("#password").val(),
            "email": $("#email").val()
        }

        $.ajax({
            type: "put",
            url: "/member/update",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(putStr)
        })
            .done(function (resp) {
                alert(resp)
                location.href = "/"
            })
            .fail(function (request) {
                alert("fail update account")
                console.log("fail update account :" + request.responseText + "/" + request.status)
                location.href = "/"
            })

    })

    $("#btnDelAcc").click(function () {

        if (!confirm("삭제하시겠습니까?")) {
            return;
        }

        $.ajax({
            type: "delete",
            url: "/member/delete",
            data: {
                "username": $("#username").val()
            }
        })
            .done(function () {
                alert("success delete")
                location.href = "/"
            })
            .fail(function (request) {
                alert("fail delete")
                console.log("fail delete account :" + request.responseText + "/" + request.status)
                location.href = "/"
            })

    })


})

function fDel(username) {

    $.ajax({
        type: "delete",
        url: "/admin/delete/" + username
    })
        .done(function () {
            alert("success delete member")
            location.href = "/admin/list"
        })
        .fail(function () {
            alert("fail delete member")
        })
}
