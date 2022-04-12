<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jqueryAddress.AddressVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jqueryAddress.JAddressDAOImpl"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String field = request.getParameter("field");
String word = request.getParameter("word");

JAddressDAO dao = JAddressDAOImpl.getInstance();
ArrayList<AddressVO> a_avo = dao.searchList(field, word);
int count = dao.getCount(field, word);

// json 형태로 변환하여 결과 값을 돌려준다.
JSONArray jsonarr = new JSONArray();
for (AddressVO avo : a_avo) {
	JSONObject obj = new JSONObject();
	obj.put("num", avo.getNum());
	obj.put("name", avo.getName());
	obj.put("addr", avo.getAddr());
	obj.put("tel", avo.getTel());
	obj.put("zipcode", avo.getZipcode());
	jsonarr.add(obj);
}
// count도 json obj로 변환
JSONObject countObj = new JSONObject();
countObj.put("count", count);

// count, array 모두 포함한 jsonobj 생성
JSONObject mainObj = new JSONObject();
mainObj.put("jsonarr", jsonarr);
mainObj.put("countObj", countObj);

out.println(mainObj.toString());
%>