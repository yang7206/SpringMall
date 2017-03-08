package com.mall.application;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by yangxiaoyu on 17/3/5.
 */
public class ApplicationContextLisenter implements ServletContextListener {
    private static WebApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        context = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        context = null;
    }

    public static WebApplicationContext getContext() {
        return context;
    }

    public static <T> T getService(String name) {
        if (context == null) return null;
        Object object = context.getBean(name);
        if (object == null) return null;
        return (T) object;
    }
}
