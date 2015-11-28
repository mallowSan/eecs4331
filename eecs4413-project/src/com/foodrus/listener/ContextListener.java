package com.foodrus.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.foodrus.util.Constants.ServletAttribute;

/**
 * Application Lifecycle Listener implementation class ContextListener
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        super();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event)  { 

    }

    @Override
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext(); 
    	context.setAttribute(ServletAttribute.CONTEXT_PATH, context.getContextPath());
    }
}
