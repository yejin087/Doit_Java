<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Image List</title>
</head>
<body>
	<div class="container">
		<h2>File Images</h2>
		<div class="row">
			<c:forEach items="${f_arr}" var="item">
				<div class="col">
					<div class="card" style="width: 200px">
						<img class="card-img-top" src="../upload/${item.image}" alt="Card image" style="width: 100%">
						<div class="card-body">
							<h4 class="card-title">${item.title}</h4>
							<p class="card-text">${item.name}</p>
							<a href="#" class="btn btn-primary">See Profile</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>