<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUEST UPDATE</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<form action="gupdate" method="post">
		<input type="hidden" name="ipaddr" value="123123">
		<input type="hidden" name="num" value="${guest.num}">
		<table>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name" value="${guest.name}"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${guest.content}"></td>
			</tr>
			<tr>
				<td>평가</td>
				<td><input type="radio" name="grade" value="excellent"> 아주 잘함(excellent) <input type="radio" name="grade" value="good"> 잘함(good) <input type="radio" name="grade" value="normal"> 보통(normal) <input type="radio" name="grade" value="fail"> 노력(fail)</td>
				<script>
					$("input:radio[value='${guest.grade}']").prop("checked",
							true)
				</script>
			</tr>

			<tr>
				<td><input type="submit" value="update"></td>
				<td><input type="button" value="delete" onclick="location.href='gdelete?num=${guest.num}'"></td>
			</tr>
		</table>
	</form>
</body>
<script>
	
</script>
</html>