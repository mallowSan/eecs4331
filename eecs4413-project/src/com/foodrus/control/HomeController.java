package com.foodrus.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.util.Constants.ViewPath;

public class HomeController implements Controller {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		return ViewPath.HOME;
	}
}
