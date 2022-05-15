<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <script src="/js/login.js"></script>
        <div class="container mt-5">

            <form action="login" method="post">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter ID" name="username">
                </div>

                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password"
                        name="password">
                </div>

                <button class="btn btn-success" id="btnLogin">Login</button>
                <c:if test="${not empty errorMsg }">
                    <b>${errorMsg}</b>
                </c:if>
            </form>
        </div>