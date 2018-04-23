package com.wap;

import com.model.event.Event;
import com.model.event.EventServiceImpl;
import com.utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static com.utils.Utils.*;

@WebServlet("/create")
public class CreateEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Event event = new Event();
        String title = extractValue(request, "title", "");
        LocalDate startDate = extractDate(request, "start_date", LocalDate.now());
        LocalDate endDate = extractDate(request, "end_date", LocalDate.now());
        String beginLocation = extractValue(request, "begin_location", "");
        String endLocation = extractValue(request, "end_location", "");
        Float distance = extractNumber(request, "distance", Float.valueOf(0));
        String comment = extractValue(request, "comment", "");
        String status = extractValue(request, "status", "");

        event.setTitle(title);
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setBeginLocation(beginLocation);
        event.setEndLocation(endLocation);
        event.setDistance(distance);
        event.setComment(comment);
        event.setStatus(status);
        event.setAccidentDescription("");
        event.setAccidentLocation("");
        event.setHasAccident(false);
        Services.EventService.insert(event);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("create_event.jsp");
        view.forward(request, response);
    }
}
