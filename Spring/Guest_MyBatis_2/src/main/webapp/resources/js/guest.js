
$(function() {
	loadData("", "")
	$("#send").click(sendIt)// send.click
	$("#btnSearch").click(function() {
		loadData($("#field").val(), $("#word").val())
	})// btnSearch
})// function

// 입력값 유효성 검사
function showRequest() {
	if (!$("#name").val()) {
		alert("글쓴이를 입력하세요")
		$("#name").focus()
		return false
	}

	if (!$("#content").val()) {
		alert("글내용을 입력하세요")
		$("#content").focus()
		return false
	}

	if ($("input:radio[name=grade]:checked").length == 0) {
		alert("평가하세요")
		return false
	}

	return true;
} // showRequest

// 모든 내용 뿌리기
function loadData(field, word) {
	$.getJSON("list", {
		"field": field,
		"word": word
	}, function(resp) {
		//alert(resp.count)
		$("#cntDiv").text("count : " + resp.count)
		// name, content, grade
		var str = ""
		$.each(resp.guest_list, function(index, val) {
			str += "name : <a href='javascript:loadView(" + val.num + ")'>"
				+ val.name + "</a>" + "<br>"
			str += "content : " + val.content + "<br>"
			str += "grade : " + val.grade + "<br>"
			str += "<a href='javascript:fdelete(" + val.num
				+ ")'> del </a>" + "<br><br>"
		})// each

		$("#result").html(str)
	})// getJSON
}// loadData

// 선택 결과 가져오기
function loadView(num) {
	$.getJSON("view", {
		"num": num
	}, function(resp) {
		var str = ""
		str += "name : " + resp.name + "<br>"
		str += "content : " + resp.content + "<br>"
		str += "grade : " + resp.grade + "<br>"
		str += "created : " + resp.created + "<br>"
		str += "ipaddr : " + resp.ipaddr + "<br><br>"

		$("#viewDiv").html(str)
	})// getJSON
}// loadView

function fdelete(num) {
	$.ajax({
		type: "DELETE", // 넘어가는 방식이 delete
		url: "delete/" + num,
		success: function(resp) {
			alert(resp)
			loadData("", "")
		},
		error: function(e) {
			alert("error")
		}
	})// ajax
}// fdelete

function sendIt() {

	
	var postString = {
		"name": $("#name").val(),
		"content": $("#content").val(),
		"grade": $("input:radio[name=grade]:checked").val()
	}

	$.ajax({
		type: "post",
		url: "insert",
		contentType: "application/json;charset=utf-8", // 전송할 형태가 json
		data: JSON.stringify(postString), // JSON 형태로 변환
		success: function(resp) {
			alert(resp)
			loadData()
		},
		error: function(e) {
			alert("error " + e)
		}
	}) // ajax
} // sendIt
