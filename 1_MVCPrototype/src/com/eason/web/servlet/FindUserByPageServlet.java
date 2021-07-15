package com.eason.web.servlet;

import com.eason.domain.PageBean;
import com.eason.domain.User;
import com.eason.service.impl.UserServiceImpl;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _currentPage = request.getParameter("currentPage");
        String _row = request.getParameter("row");

        if(_currentPage == null || _currentPage.equals("")){
            _currentPage ="1";
        }

        if (_row == null || _row.equals("")) {
            _row = "1";
        }

        int currentPage = Integer.parseInt(_currentPage);
        int row = Integer.parseInt(_row);


        UserServiceImpl userService = new UserServiceImpl();

        int totalCount = userService.findTotalCount();
        int pageBegin= (currentPage-1)*row;

        List<User> usersByPage = userService.findUsersByPage(pageBegin,row);

        int totalPage = totalCount%row==0?totalCount/row:totalCount/row+1;

        PageBean pb = new PageBean();

        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        pb.setCurrentPage(currentPage);
        pb.setList(usersByPage);
        pb.setRow(row);

        System.out.println(pb);
        List list = pb.getList();
        for (Object u : list) {
            System.out.println(((User)u).toString());
        }

        request.setAttribute("pb",pb);

        response.sendRedirect("/list.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
