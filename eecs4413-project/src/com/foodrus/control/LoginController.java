package com.foodrus.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.util.Constants.ViewPath;

public class LoginController implements Controller {

	public LoginController() {
		super();
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		return ViewPath.HOME;
	}
}
