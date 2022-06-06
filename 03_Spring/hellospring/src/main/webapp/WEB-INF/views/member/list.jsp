<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <script src="/js/member.js"></script>
        <div class="container mt-5">
            <table class="table table-hover">
                <thead>
                    <th>번호</th>
                    <th>아이디</th>
                    <th>이메일</th>

                </thead>
                <tbody>
                    <c:forEach items="${memberList}" var="member" varStatus="status">
                        <tr>
                            <td>${status.index}</td>
                            <td> ${member.username}</td>
                            <td>${member.email}</td>
                            <c:if test="${member.role== 'ROLE_USER'}">
                                <td><a href="javascript:fDel(${member.username})"> delete </a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>