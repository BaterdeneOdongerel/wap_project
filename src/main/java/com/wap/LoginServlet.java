package com.wap;



import com.model.user.UserServiceImpl;
import com.props.MessagesProp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {

    protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserServiceImpl userModel = new UserServiceImpl();
        boolean success = userModel.login(email, password);
        if (success) {

            System.out.println("Bing go");
            HttpSession session = request.getSession();
            session.setAttribute("user", userModel.getCurrentUser() );
            System.out.println( userModel.getCurrentUser().getLastName() );
            response.sendRedirect("/");

        } else {

            request.setAttribute("error",MessagesProp.INSTANCE.getProp("errorLogin"));
            System.out.println(MessagesProp.INSTANCE.getProp("errorLogin"));

            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }


    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }

}
