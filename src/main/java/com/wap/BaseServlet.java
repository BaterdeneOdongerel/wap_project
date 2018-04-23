package com.wap;

import com.model.user.User;

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
            if (filterRequest(request , response))
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

            if (filterRequest(request, response))
              get(request, response);
        } catch (Exception ex) {
            handleException(request, response, ex);
        }
    }

    private boolean filterRequest(HttpServletRequest request , HttpServletResponse response){
        if ( !(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/signup")) ){
            if(request.getSession().getAttribute("user") == null )
               try {
                   response.sendRedirect("/login");
                   return false;
               }catch (Exception ex) { return false;}
        }
        return true;
    }
    protected abstract void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    protected abstract void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
