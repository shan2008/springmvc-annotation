package com.atguigu;

import com.atguigu.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author syou
 * @date 2018/8/29.
 */
public class MyWebApplicationInitializer2 implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        ServletRegistration.Dynamic d = servletContext.addServlet("myServlet", MyServlet.class);
        d.addMapping("/custom");
    }
}
