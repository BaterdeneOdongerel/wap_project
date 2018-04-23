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

</head>
<body>

<jsp:include page="nav.jsp" />

<div class="back_container">
    <div class="container text-center">
        <div class="body_content text-left">
            <h3>Create an event</h3>

            <form class="form-horizontal" action="/create_event" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">Title:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="title" placeholder="Enter the trip title">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_date">Start Date:</label>
                    <div class="col-sm-3">
                        <input type="date" class="form-control" id="start_date" name="start_date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_time">Start Time:</label>
                    <div class="col-sm-3">
                        <input type="time" class="form-control" id="start_time" name="start_time">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_location">Start Location:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="start_location" id="start_location" placeholder="Enter starting location">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="end_location">End Location:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name= "end_location" id="end_location" placeholder="Enter ending location">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="distance">Length of the path:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name= "distance" id="distance" placeholder="Enter length of the path">
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="comment">Comment:</label>
                    <div class="col-sm-7">
                        <textarea  rows="3" class="form-control" name= "comment" id="comment" placeholder="Enter ending location">wdawdd awd wwdawdawd
                        </textarea>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success btn-lg">Create</button>
                        <button type="button" class="btn btn-danger btn-lg">Cancel </button>
                    </div>
                </div>

            </form>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
