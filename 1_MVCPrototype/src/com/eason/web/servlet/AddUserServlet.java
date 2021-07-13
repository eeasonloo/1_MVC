package com.eason.web.servlet;

import com.eason.domain.User;
import com.eason.service.UserService;
import com.eason.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        User addUser = new User();
        Map<String, String[]> map = request.getParameterMap();

        try {
            BeanUtils.populate(addUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService = new UserServiceImpl();
        boolean flag = userService.addUser(addUser);

        HttpSession session = request.getSession();
        if(!flag){
            session.setAttribute("add_msg","The User is not added!");
            return;
        }else{
            session.setAttribute("add_msg","The User added successfully!");
            response.sendRedirect(request.getContextPath()+"/userListServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
