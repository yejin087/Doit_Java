<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <link rel="stylesheet"
                        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
                    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                    <title>header</title>
                </head>

                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal" var="principal" />
                </sec:authorize>

                <body>

                    <div class="jumbotron jumbotron-fluid mb-0">
                        <div class="container">
                            <h2>Hello Spring</h2>
                        </div>
                    </div>
                    <nav class="navbar navbar-expand-sm bg-success navbar-dark">

                        <div class="container">
                            <!-- 왼쪽 네비 블럭 -->
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="navbar-brand" href="/">HOME</a>
                                </li>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/admin/list">Member List</a>
                                    </li>
                                </sec:authorize>
                            </ul>

                            <ul class="navbar-nav">
                                <sec:authorize access="isAnonymous()">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/member/join">Join</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/member/login">Login</a>
                                    </li>
                                </sec:authorize>
                                <sec:authorize access="isAuthenticated()">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/member/update">Update</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/member/logout">Logout (${principal.username})</a>
                                    </li>
                                </sec:authorize>

                            </ul>


                        </div>
                    </nav>


                </body>

                </html>