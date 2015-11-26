package com.foodrus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.control.Controller;
import com.foodrus.util.Constants.Resource;
import com.foodrus.util.Constants.ServletAttribute;
import com.foodrus.util.Constants.ViewPath;

/**
 * Servlet implementation class RequestDispatcher
 */
@WebServlet(urlPatterns={"/home/*", "/Home/*", "/Action/*", "/action/*"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * instantiate a request dispatcher that dispatches
     * requests based on the URL
     */
    public DispatcherServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}
    
    // *** process POST/GET requests
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// *** parse the requested resource URI
		String uri = request.getPathInfo();
		if( uri == null){
			uri = request.getRequestURI().substring(request.getContextPath().length());
		}
		uri = uri.toLowerCase();
		System.out.println("Requested URI >>> " + uri);
		
		// *** get the Controller for that URI
		Controller controller = Resource.RESOURCE_MAP.get(uri);
		if(controller == null){
			throw new ServletException("No Controller defined for URI ["+uri+"]");
		}
		
		// *** let controller handles the request, then check
		// *** if it returns a View, if it does 
		// *** make the view of controller as a target attribute
		// *** and forward the request to the dashBoard page
		// *** otherwise do nothing.
		String target = controller.handleRequest(request, response);
		if(target != null){
			request.setAttribute(ServletAttribute.TARGET, target);
			request.getRequestDispatcher(ViewPath.DASH_BOARD).forward(request, response);
		}
	}
}
