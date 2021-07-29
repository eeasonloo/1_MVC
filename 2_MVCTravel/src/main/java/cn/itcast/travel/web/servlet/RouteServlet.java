package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidStr = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int cid = 0;
        int currentPage = 1;
        int pageSize = 5;

        if(cidStr != null && !(cidStr.equals("")) && cidStr.length()>0){
            cid = Integer.parseInt(cidStr);
        }
        if(currentPageStr != null && !(currentPageStr.equals("")) && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }
        if(pageSizeStr != null && !(pageSizeStr.equals("")) && pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        PageBean<Route> pageBean = routeService.pageQuery(cid,currentPage,pageSize);

        writeValue(pageBean,response);

    }


}
