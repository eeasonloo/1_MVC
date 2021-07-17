package com.eason.web.filter;

import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsForFilter implements Filter {

    List<String> sensitiveWordsList = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWordsForFilter.txt");
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

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getParameter")){
                    String value = (String) method.invoke(servletRequest,args);

                    if(value != null){
                        for (String sensitiveWord : sensitiveWordsList) {
                            if(value.contains(sensitiveWord)) {
                                value = value.replaceAll(sensitiveWord, "cutiePie");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest,args);
            }
        });
        filterChain.doFilter(proxy_req,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
