package com.atguigu;

import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.atguigu.config.AppConfig;
import com.atguigu.config.RootConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 还可同过web.xml来加载RootConfig
 */
//web容器启动的时候创建对象；调用方法来初始化容器以前前端控制器
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取根容器的配置类；（Spring的配置文件）   父容器；
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{RootConfig.class};
    }

    //获取web容器的配置类（SpringMVC配置文件）  子容器；
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[]{"/"};
    }

    //customizeRegistration


    /**
     * 文件上传定制配置路径文件大小,MyWebAppInitializer 复写customizeRegistration
     * 2.中方式
     * // 文件上传配置&大小小在
     * <p>
     * // 文件上传配置&大小小在
     *
     * @Bean public MultipartResolver multipartResolver() {
     * CommonsMultipartResolver m= new CommonsMultipartResolver();
     * m.setUploadTempDir("/");
     * m.setMaxInMemorySize(111000);
     * m.setMaxInMemorySize(0);
     * return m;
     * }
     * }
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/", 2097152, 4194304, 0));

        
    }

}
