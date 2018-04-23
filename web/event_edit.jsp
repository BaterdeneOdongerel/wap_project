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

</head>
<body>

<jsp:include page="nav.jsp" />

<div class="back_container">
    <div class="container text-center">
        <div class="body_content text-left">
            <h3>Edit the event <span style="float: right;" class="label label-success">In process</span>
                <span style="float: right;" class="label label-warning"></span> </h3>
            
            <div class="form-horizontal" action="/action_page.php">


                <div class="form-group">
                    <label class="control-label col-sm-2" for="title">Title:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="title" placeholder="Enter the trip title">

                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Start Date:</label>
                    <div class="col-sm-3">
                        <input type="date" class="form-control" id="date" name="date">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="time">Start Time:</label>
                    <div class="col-sm-3">
                        <input type="time" class="form-control" id="time" name="time">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>

                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="start_location">Start Location:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="start_location" placeholder="Enter starting location">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="end_location">End Location:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name= "end_location" id="end_location" placeholder="Enter ending location">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="length_path">Length of the path:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name= "length_path" id="length_path" placeholder="Enter length of the path">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="comment">Comment:</label>
                    <div class="col-sm-7">
                        <textarea  rows="3" class="form-control" name= "comment" id="comment" placeholder="Enter ending location">wdawdd awd wwdawdawd
                        </textarea>
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="current_location">Current Location:</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name= "current_location" id="current_location" placeholder="Enter current location">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="current_length">Current length:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name= "current_length" id="current_length" placeholder="Enter current length of the path">
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-wrench">  </span>
                        </button>
                        <button type="button" class="btn btn-success">
                            <span class="glyphicon glyphicon-upload">  </span>
                        </button>
                    </div>
                </div>

                <div class="form-group ">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button data-toggle="collapse" data-target="#demo" type="button" class="btn btn-warning btn-lg" >Raise emergency flag</button>

                        <div id="demo" class="collapse mt-2" >
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="accident_comment">Accident Info:</label>
                                <div class="col-sm-7">
                                    <textarea  rows="3" class="form-control" name= "accident_comment" id="accident_comment" placeholder="Enter ending location">wdawdd awd wwdawdawd
                                    </textarea>
                                </div>

                                <div class="col-sm-10">
                                    <button type="button" class="btn btn-danger btn-lg"> Raise Flag </button>
                                    <button type="button" class="btn btn-success btn-lg"> Resume the trip </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success btn-lg">Join</button>
                        <button type="button" class="btn btn-danger btn-lg">Leave </button>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success btn-lg">Start the ride</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
</body>
</html>
