package com.servlet;

import com.model.event.Event;
import com.model.event.EventServiceImpl;
import com.model.user.User;
import com.model.userevent.UserEvent;
import com.model.userevent.UserEventImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/live")

public class LiveServlet extends BaseServlet {
    protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        //TODO: use enum for the status
        List<Event> events = Services.EventService.selectByStatus("On Going");
        List<UserEvent> userEvents = new ArrayList<>();
        for (Event e: events) {
            UserEvent r = Services.UserEventService.selectByIds(user.getUserId() , e.getId());
            userEvents.add(r);
        }

        request.setAttribute("events" , events);
        request.setAttribute("userevent",userEvents);

        RequestDispatcher view = request.getRequestDispatcher("live_events.jsp");
        view.forward(request, response);
    }

}
