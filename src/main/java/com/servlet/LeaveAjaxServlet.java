package com.servlet;

import com.model.userevent.UserEventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.utils.Utils.extractInteger;

@WebServlet(name = "LeaveAjaxServlet")
public class LeaveAjaxServlet extends BaseServlet {
    protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = extractInteger(request, "eventid", 0);
        int userId = extractInteger(request, "userid", 0);
        Services.UserEventService.delete( eventId , userId);
        response.getWriter().println("SUCCESS");
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
