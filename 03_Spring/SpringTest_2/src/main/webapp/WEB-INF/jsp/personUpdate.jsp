<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<h2>개인 정보 수정</h2>
	<form action="person_update.go" method="post">
		이름 :
		<input type="text" name="name" value="${person.name }">
		<br>
		아이디:
		<input type="text" name="id" value="${person.id }" readonly>
		<br>
		패스워드 :
		<input type="password" name="password">
		<br>
		성별:
		<label for="man"> 남</label>
		<input type="radio" name="gender" id="man" value="남" checked>
		여
		<input type="radio" name="gender" value="여">
		<br>
		직업:
		<select id ="job" name="job">
			<option value="회사원">회사원
			<option value="학생">학생
			<option value="기타">기타
		</select>

		<script>
		/* 	if ("${person.gender}" == "남") {
				$("input:radio[value='남']").prop("checked", true)
			} else {
				$("input:radio[value='여']").prop("checked", true)
			} */
			$("input:radio[value='${person.gender}']").prop("checked", true)
			
			$("#job option").each( function(){
				if( $(this).val() == "${person.job}"){
					$(this).prop("selected",true)
				}
			})
			
		</script>
		<br>
		<br>
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</body>
</html>