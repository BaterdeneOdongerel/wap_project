package com.wap;

import com.model.event.Event;
import com.model.event.EventServiceImpl;
import com.model.user.User;
import com.model.userevent.UserEvent;
import com.model.userevent.UserEventImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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


        EventServiceImpl eventService = new EventServiceImpl();
        UserEventImpl userEventIml = new UserEventImpl();

        User user = (User)request.getSession().getAttribute("user");
        List<Event> events = eventService.selectByStatus("On Going");

        List<UserEvent> userEvents = new ArrayList<>();
        for (Event e: events) {
            UserEvent r = userEventIml.selectByUserIdEventid(user , e);
            userEvents.add(r);
        }


        request.setAttribute("events" , events);
        request.setAttribute("userevent",userEvents);

        RequestDispatcher view = request.getRequestDispatcher("live_events.jsp");
        view.forward(request, response);
    }

}
