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

    <title>Cycla - Create Event</title>
    <jsp:include page="header.jsp" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
    <script type="text/javascript" src="./public/js/create_event.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
</head>
<body>

<jsp:include page="nav.jsp" />

<div class="back_container">
    <div class="container text-center">
        <div class="body_content text-left">
            <h3>Create an event</h3>
            <div id="error-box" class="alert alert-danger alert-dismissible fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong id="notification"></strong>
            </div>

            <form class="form-horizontal" id="create_form" action="/create_event" method="POST">
                <div id="errorMessage" class="error"></div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">Title</label>
                    <div class="col-sm-7">
                        <input required type="text" class="form-control" name="title" id="title" placeholder="Enter the trip title">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_date">Start Date</label>
                    <div class="col-sm-3">
                        <input required type="text" id="start_date" class="form-control" id="start_date" name="start_date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_time">Start Time</label>
                    <div class="col-sm-3">
                        <input required id="start_time" type="text" class="form-control" id="start_time" name="start_time">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="begin_location">Start Location</label>
                    <div class="col-sm-7">
                        <input required type="text" id="begin_location" class="form-control" name="begin_location" id="begin_location" placeholder="Enter starting location">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="end_location">End Location</label>
                    <div class="col-sm-7">
                        <input required type="text" id="end_location" class="form-control" name= "end_location" id="end_location" placeholder="Enter ending location">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="distance">Distance</label>
                    <div class="col-sm-3">
                        <input required type="number"  id="distance" class="form-control" name= "distance" id="distance" placeholder="Enter length of the path">
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="comment">Comment</label>
                    <div class="col-sm-7">
                        <textarea  rows="3" class="form-control" name= "comment" id="comment" placeholder="Enter ending location"></textarea>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" id="submit" class="btn btn-success btn-lg">Create</button>
                        <button type="button" id="cancel" class="btn btn-danger btn-lg">Reset </button>
                    </div>
                </div>

            </form>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
