<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2018
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>$Title$</title>
    <jsp:include page="header.jsp" />
    <link rel="stylesheet" type="text/css" href="./public/css/main.css">
</head>
<body>
<script src="./public/js/user.js"></script>
<jsp:include page="nav.jsp" />

<div class="back_container">
    <div class="container text-center">
        <div class="body_content text-left">
            <h3>Users</h3>
            <div class="loader">
                <center>
                    <img class="loading-image" src="./public/images/loader.gif" alt="loading.." width="200px"  height="200px">
                </center>
            </div>
            <div class="col-sm-5">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="search" id="search">
                    <div class="input-group-btn">
                        <button class="btn btn-default" id="btnsearch"type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </div>

            <table class="table table-striped" id="mytable">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                    <th>Events</th>
                </tr>

                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
