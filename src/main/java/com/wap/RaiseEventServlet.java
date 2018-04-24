package com.wap;

import com.model.event.Event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static com.utils.Utils.*;

@WebServlet("/raise")
public class RaiseEventServlet extends BaseServlet {
    protected void post(HttpServletRequest request, HttpServletResponse response) {
        String id = extractValue(request, "id", "");
        Event event = new Event();
        event.setId(Integer.parseInt(id));
        String accidentLocation = extractValue(request, "accident_location", "");
        String accidentDescription = extractValue(request, "accident_description", "");

        event.setAccidentLocation(accidentLocation);
        event.setAccidentDescription(accidentDescription);
        event.setHasAccident(true);
        Services.EventService.raise(event);
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
