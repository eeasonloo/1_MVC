package com.eason.web.servlet;

import com.eason.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("userCheckbox");

       /* for (String s : id) {
            System.out.println(s);
        }*/
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.delSelectedUser(ids);

        HttpSession session = request.getSession();

        if(flag){
            request.setAttribute("del_msg","Delete Successfully!");
        }else
            request.setAttribute("del_msg","Delete Error!");


        response.sendRedirect(request.getContextPath()+"/userListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
