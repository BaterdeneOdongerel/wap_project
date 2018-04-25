package com.servlet;

import com.google.gson.Gson;
import com.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.utils.Utils.extractValue;

@WebServlet("/userAjax")
public class UserAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username  = extractValue(request, "username", "");
        List<User> users = Services.UserService.selectByName(username);

        String JSONguests;
        JSONguests = new Gson().toJson(users);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JSONguests);
    }
}
