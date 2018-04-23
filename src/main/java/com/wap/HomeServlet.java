package com.wap;
import com.model.event.Event;
import com.model.event.EventServiceImpl;
import com.model.user.User;
import com.model.userevent.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeServlet extends BaseServlet {


    protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EventServiceImpl eventService = new EventServiceImpl();
        UserEventImpl userEventIml = new UserEventImpl();

        User user = (User)request.getSession().getAttribute("user");
        List<Event> events = eventService.selectByStatus("Upcoming");
        List<UserEvent> userEvents = new ArrayList<>();
        for (Event e: events) {
            UserEvent r = userEventIml.selectByUserIdEventid(user , e);
            userEvents.add(r);
            System.out.println( (r != null ? r.getEventId() : "-1") );
        }

        System.out.println("===>" + events.size());
        for (Event e : events) {
            System.out.println("=======>"  + e.getTitle());
        }
        request.setAttribute("events" , events);

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);


    }
}
