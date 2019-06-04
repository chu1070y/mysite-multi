package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	String contextConfigLocation = sce.getServletContext().getInitParameter("contextConfig");
    	
    	System.out.println("Container Starts...." + contextConfigLocation);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	
}
