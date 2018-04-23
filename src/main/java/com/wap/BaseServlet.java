package com.wap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Van on 4/23/18.
 */
public abstract class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            post(request, response);
        } catch (Exception ex) {
            handleException(request, response, ex);
        }

    }

    private void handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("error.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            get(request, response);
        } catch (Exception ex) {
            handleException(request, response, ex);
        }
    }

    protected abstract void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    protected abstract void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}