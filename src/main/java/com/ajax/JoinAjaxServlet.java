package com.ajax;

import com.model.userevent.UserEventImpl;
import com.wap.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.utils.Utils.extractInteger;
import static com.utils.Utils.extractValue;

@WebServlet(name = "JoinAjaxServlet")
public class JoinAjaxServlet extends BaseServlet {
    protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventid = extractInteger(request, "eventid", 0);
        int userid = extractInteger(request, "userid", 0);
        UserEventImpl userEventImp = new UserEventImpl();
        userEventImp.insert( eventid , userid);
        response.getWriter().println("SUCCESS");
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
