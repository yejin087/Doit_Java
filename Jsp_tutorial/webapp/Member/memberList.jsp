<%@page import="com.member.dao.MemberDAO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/member.js"></script>
<title>Member List</title>
</head>

<%
MemberDAO dao = MemberDAOImpl.getInstance();
ArrayList<MemberDTO> a_mem = dao.memberList();
int count = dao.getcount();
String sid = (String) session.getAttribute("sUserid");
%>

<body>
	<div class="container mt-5">
		<div align="right">
			<a href="memberView.jsp"><%=sid%></a> 관리자님 반갑습니다. / <a href="logout.jsp">로그아웃</a>
		</div>
		<h2>
			회원 리스트 (<span id="cntSpan"><%=count%> </span>)
		</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>구분</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (MemberDTO mem : a_mem) {
					String mode = mem.getAdmin() == 0 ? "일반회원" : "관리자";
				%>
				<tr>
					<td><%=mem.getName()%></td>
					<td><%=mem.getUserid()%></td>
					<td><%=mem.getPhone()%></td>
					<td><%=mem.getEmail()%></td>
					<td><%=mode%></td>
					<td>
						<a href="javascript:del('<%=mem.getUserid()%>','<%=mode%>')">삭제</a>
					</td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>