<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.member.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 관리자가 삭제 버튼 눌렀을 떄 
request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");

MemberDAO dao = MemberDAOImpl.getInstance();
dao.memeberDelete(userid);
ArrayList<MemberDTO> a_mem = dao.memberList();
int count = dao.getcount();

JSONArray a_memObj = new JSONArray();
for ( MemberDTO member : a_mem ){
	String mode = member.getAdmin()==0?"일반회원":"관리자";
	JSONObject obj = new JSONObject();
	obj.put("name", member.getName());
	obj.put("userid", member.getUserid());
	obj.put("pwd", member.getPwd());
	obj.put("email", member.getEmail());
	obj.put("tel", member.getPhone());
	obj.put("admin", mode);
	a_memObj.add(obj);
}

JSONObject countObj = new JSONObject();
countObj.put("count", count);

JSONObject mainObj = new JSONObject();
mainObj.put("m_a_memObj", a_memObj);
mainObj.put("m_countObj", countObj);

out.println(mainObj.toString());
%>