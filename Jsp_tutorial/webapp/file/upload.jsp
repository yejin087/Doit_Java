<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		글쓴이 :
		<input type="text" name="name">
		<br> title :
		<input type="text" name=" title">
		<br> file :
		<input type="file" name="fileUpload">
		<br>
		<input type="submit" value="submit">
	</form>
</body>
</html>