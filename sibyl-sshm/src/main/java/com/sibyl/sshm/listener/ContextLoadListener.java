package com.sibyl.sshm.listener;

import com.sibyl.sshm.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Classname ContextLoadListener
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 15:05
 */

public class ContextLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //将spring上下文保存到servletContext中
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("app",app);
        System.err.println("listener => spring 容器 创建完毕");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
