package com.wap;

import com.model.event.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.utils.Utils.extractValue;

@WebServlet("/status")
public class ChangeStatusServlet extends BaseServlet {
    protected void post(HttpServletRequest request, HttpServletResponse response) {
        String id = extractValue(request, "id", "");
        String status = extractValue(request, "status", "");
        Services.EventService.updateStatus(status, Integer.parseInt(id));
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
