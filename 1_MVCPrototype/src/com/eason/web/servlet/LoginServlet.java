package com.eason.web.servlet;

import com.eason.dao.impl.UserDaoImpl;
import com.eason.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String verifycode = req.getParameter("verifycode");
        String generatedVerifyCode = (String) req.getSession().getAttribute("CHECKCODE_SERVER");

        if(!generatedVerifyCode.equalsIgnoreCase(verifycode)){
            req.setAttribute("login.msg","VerifyCodeWrong!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }

        Map<String, String[]> map = req.getParameterMap();
        User loginUser = new User();


        try {
            BeanUtils.populate(loginUser,map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = userDaoImpl.userlogin(loginUser);
        System.out.println(user.getName()+user.getPassword());

        if(user== null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
