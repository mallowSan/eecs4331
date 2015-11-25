package com.foodrus.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	public LoginController() {
		super();
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		return null;
	}
}
