<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2018
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.model.event.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.userevent.UserEvent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Cycla</title>
    <jsp:include page="header.jsp" />

</head>
<body>

<jsp:include page="nav.jsp" />

<div class="back_container">
    <div class="container text-center">
        <div class="body_content text-left">



            <div class="loader">
                <center>
                    <img class="loading-image" src="./public/images/loader.gif" alt="loading.." width="200px"  height="200px">
                </center>
            </div>

            <h3>Live Cycling Events</h3>

            <% List<Event> event = (List<Event>)request.getAttribute("events");%>
            <% List<UserEvent> userEvent = (List<UserEvent>)request.getAttribute("userevent");%>

            <div class="row">
                <% for (int i = 0; i < event.size(); i ++ ) {%>
                <% if ( i % 4 == 0 && i > 0 ) {%>
            </div>
            <div class="row">
                <% } %>

                <div class="column" id="<%=event.get(i).getId()%>">
                    <h5><%= event.get(i).getTitle()%>
                        <span event="notjoined" class="label label-warning <%= userEvent.get(i) != null ? "hidden" : ""%>">Not joined</span>s
                        <span event="joined" class="label label-success <%= userEvent.get(i) == null ? "hidden" : ""%>">Joined</span>
                        <span class="label label-danger <%= !event.get(i).getHasAccident() ? "hidden" : ""%>">Raising</span>
                    </h5>
                    <p> start: <%= event.get(i).getStartDate() %> </p>
                    <p> <%= event.get(i).getBeginLocation() %> </p>
                    <span class="label label-info">On Going</span>
                    <a><button type="button" event="edit" class="btn btn-primary btn-sm" data-event="<%=event.get(i).getId()%>" data-user="${user.userId}">Details</button></a>
                </div>
                <% }%>

            </div>


        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
