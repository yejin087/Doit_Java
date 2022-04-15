<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.board.dto.CommentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int bnum = Integer.parseInt(request.getParameter("num"));
//int bnum  = 49;
BoardDAO dao = BoardDAO.getInstance();
ArrayList<CommentDTO> array_comm = dao.commentList(bnum);

int count = dao.getcommCount(bnum);

JSONArray j_a_comm = new JSONArray();

for (CommentDTO comm : array_comm) {
	JSONObject jobj_comm = new JSONObject();
	jobj_comm.put("cnum", comm.getCnum());
	jobj_comm.put("msg", comm.getMsg());
	jobj_comm.put("userid", comm.getUserid());
	jobj_comm.put("regdate", comm.getRegdate());
	jobj_comm.put("bnum", comm.getBnum());
	j_a_comm.add(jobj_comm);
}

JSONObject jobj_count = new JSONObject();
jobj_count.put("count", count);

JSONObject jobj_main = new JSONObject();
jobj_main.put("j_a_comm", j_a_comm);
jobj_main.put("jobj_count", jobj_count);

out.println(jobj_main.toString());
%>