<%@page import="com.board.dto.BoardDTO"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 페이지</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%
int num = Integer.parseInt(request.getParameter("num"));
BoardDAO dao = BoardDAO.getInstance();
BoardDTO board = dao.findByNum(num);
int ref = board.getRef();
int re_step = board.getRe_step();
int re_level = board.getRe_level();
%>
<script>
	function del() {
		if (confirm("삭제할까요?")) {
			location.href = "deletePro.jsp?num=" +
<%=board.getNum()%>
	;
		}
	}
</script>
<body>
	<h2>글 내용 보기</h2>
	<input type="hidden" id="num" value="<%=num%>">
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td><%=board.getNum()%></td>
			<td>조회수</td>
			<td><%=board.getReadcount()%></td>
		</tr>

		<tr>
			<td>작성자</td>
			<td><%=board.getWriter()%></td>
			<td>작성일</td>
			<td><%=board.getReg_date()%></td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td colspan="3">
				<%=board.getSubject()%></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td colspan="3" width="300" height="300">
				<%=board.getContent()%></td>

		</tr>
		<tr>
			<td colspan="4" align="center">
				<button onclick="location.href='updateForm.jsp?num=<%=num%>'">글 수정 폼</button>
				<button onclick="del()">삭제</button>
				<button onclick="location.href='writeForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">답글 쓰기</button>
				<button onclick="location.href='list.jsp'">전체보기</button>
			</td>
		</tr>
	</table>

	<br>
	<br>
	<div align="left">
		<textarea rows="5" cols="50" id="msg"></textarea>
		<input type="button" value="comment Insert" id="commentBtn">
	</div>
	<br> comment (
	<span id="spanCnt"> </span>)
	<br>
	<br>
	<div id="result"></div>

	<script>
		var init = function() {
			$.getJSON("commentList.jsp", {
				"num" : $("#num").val()
			}, function(resp) {
				var str = "<table>";
				$.each(resp.j_a_comm, function(key, val) {
					str += "<tr>"
					str += "<td>" + val.msg + "</td>"
					str += "<td>" + val.userid + "</td>"
					str += "<td>" + val.regdate + "</td>"
					str += "</tr>"
				})// each
				str += "</table>";

				$("#result").html(str);
				$("#spanCnt").text(resp.jobj_count.count);

			})// getjson
		} // init

		$("#commentBtn").on("click", function() {
			if ($("#msg").val() == "") {
				alert("댓글을 입력하세요");
				return;
			}

			$.ajax({
				type : "get",
				url : "commentInsertPro.jsp",
				data : {
					"msg" : $("#msg").val(),
					"num" : $("#num").val()
				},
				success : function(resp) {
					if (resp.trim() == 1) {
						alert("로그인 한 사람만 댓글을 쓸 수 있습니다.");
						location.href ="../member/loginForm.jsp";
					} else {
						init();
						$("#msg").val("");
					}
				},
				error : function(e) {
					alert("error : " + e);
				}
			}) // ajax
		}) // commentbtn.on

		init();
	</script>

</body>
</html>