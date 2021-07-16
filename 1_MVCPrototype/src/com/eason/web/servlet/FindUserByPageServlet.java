package com.eason.web.servlet;

import com.eason.domain.PageBean;
import com.eason.domain.User;
import com.eason.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();

        String currentPage = request.getParameter("currentPage");
        String row = request.getParameter("row");

        if(currentPage == null || currentPage.equals("")){
            currentPage ="1";
        }

        if (row == null || row.equals("")) {
            row = "5";
        }

        UserServiceImpl userService = new UserServiceImpl();

        PageBean<User> pb = userService.findUsersByPage(currentPage, row);

        request.setAttribute("pb",pb);

        request.getRequestDispatcher("/list.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
