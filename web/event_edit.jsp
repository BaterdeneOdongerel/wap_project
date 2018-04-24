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

    <title>Cycla - Update Event</title>
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
            <h3>Update ${value.title}</h3>
            <div id="error-box" class="alert alert-danger alert-dismissible fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong id="notification"></strong>
            </div>

            <form class="form-horizontal" id="create_form">
                <input class="hidden" id="id" name="id" value="${event.id}">
                <div id="errorMessage" class="error"></div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">Title</label>
                    <div class="col-sm-7">
                        <input required type="text" name="title" class="form-control" id="title" placeholder="Enter the trip title" value="${event.title}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_date">Start Date</label>
                    <div class="col-sm-3">
                        <input required type="text" id="start_date" class="form-control" id="start_date" name="start_date" value="${event.startDate}">
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
                        <input required type="text" id="begin_location" class="form-control" name="begin_location" placeholder="Enter starting location" value="${event.beginLocation}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="end_location">End Location</label>
                    <div class="col-sm-7">
                        <input required type="text" id="end_location" class="form-control" name= "end_location" id="end_location" placeholder="Enter ending location" value="${event.endLocation}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="distance">Distance</label>
                    <div class="col-sm-3">
                        <input required type="number" id="distance" class="form-control" name= "distance" id="distance" placeholder="Enter length of the path" value="${event.distance}">
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="comment">Comment</label>
                    <div class="col-sm-7">
                        <textarea  rows="3" class="form-control" name= "comment" id="comment" placeholder="Enter ending location">${event.comment}"</textarea>
                    </div>
                </div>


                <c:choose>
                    <c:when test="${'name' == 'blae'}">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" id="submit" class="btn btn-success btn-lg">Update</button>
                                <button type="button" id="start" class="btn btn-success btn-lg">Start</button>
                                <button type="button" id="stop" class="btn btn-success btn-lg">Stop</button>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${'name' == 'name'}">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" id="raise" class="btn btn-danger btn-lg">Raise</button>
                            </div>
                        </div>
                    </c:when>
                </c:choose>

            </form>

        </div>
        <div class="modal fade" id="raise_modal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Raise Event</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="accident_form">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="accident_location">Location</label>
                                <div class="col-sm-7">
                                    <input required type="text" name="accident_location" class="form-control" id="accident_location" placeholder="Enter the accident location">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Description</label>
                                <div class="col-sm-7">
                                    <textarea  rows="3" class="form-control" name= "accident_description" id="accident_description" placeholder="Enter accident location">"</textarea>
                                </div>
                            </div>
                        </form>



                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" id="raise_event" class="btn btn-default" data-dismiss="modal">Raise Event</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
