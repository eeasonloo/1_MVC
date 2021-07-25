package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("loginMethod");
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("logoutMethod");

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("registerMethod");

    }
}
