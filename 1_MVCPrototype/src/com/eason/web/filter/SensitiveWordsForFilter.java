package com.eason.web.filter;

import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsForFilter implements Filter {

    List sensitiveWordsList = new ArrayList<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/Sensitive WrdsForFilter.txt");
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;

            while ((line = br.readLine())!=null){
                sensitiveWordsList.add(line);
            }

            br.close();
            System.out.println(sensitiveWordsList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
