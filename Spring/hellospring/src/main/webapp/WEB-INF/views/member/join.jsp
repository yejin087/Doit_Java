<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
        <script src="/js/join.js"></script>

        <body>
            <div class="container mt-5">

                <div class="form-group">
                    <label for="id">id:</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter userid" name="username">
                </div>


                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password"
                        name="password">
                </div>

                <div class="form-group">
                    <label for="passwordcheck">Password Check:</label>
                    <input type="password" class="form-control" id="passwordcheck" placeholder="Enter password check">
                </div>

                <div class="form-group">
                    <label for="email">email:</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>

                <input type="radio" name="role" value="ROLE_ADMIN" id="admin">
                <label for="admin">admin</label>
                <input type="radio" name="role" value="ROLE_USER" id="user">
                <label for="user">user</label>

                <br>
                <br>

                <button type="button" class="btn btn-secondary" id="btnJoin">create account</button>

            </div>
        </body>