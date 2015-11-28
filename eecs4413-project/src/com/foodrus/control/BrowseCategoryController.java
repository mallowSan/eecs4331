package com.foodrus.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.dao.jdbp.CategoryDao;
import com.foodrus.util.Constants.ServletAttribute;
import com.foodrus.util.Constants.ViewPath;

public class BrowseCategoryController implements Controller{

	public BrowseCategoryController() {
		 super();
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute(ServletAttribute.CATEGORIES, (new CategoryDao()).getAll());
		} catch (SQLException | NamingException e) {
			throw new ServletException("Could not get Categories",e);
		}
		return ViewPath.CATEGORIES;
	}
}
