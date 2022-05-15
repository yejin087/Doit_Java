<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <script src="/js/member.js"></script>

        <body>

            <div class="container mt-5">

                <div class="form-group">
                    <label for="username">id:</label>
                    <input type="text" class="form-control" id="username" name="username" value="${member.username}"
                        readonly>
                </div>


                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password"
                        name="password">
                </div>

                <div class="form-group">
                    <label for="passwordcheck">Password Check:</label>
                    <input type="password" class="form-control" id="passwordcheck" placeholder="Enter password check"
                        name="passwordcheck">
                </div>


                <div class="form-group">
                    <label for="name">email:</label>
                    <input type="text" class="form-control" id="email" name="email" value="${member.email}">
                </div>

                <br>

                <button type="button" class="btn btn-success" id="btnUpdateAcc">update account</button>
                <button type="button" class="btn btn-danger" id="btnDelAcc">delete account</button>
                <button type="button" class="btn btn-dark" id="btnCancle" onclick="location.href='/'">cancle</button>

            </div>
        </body>