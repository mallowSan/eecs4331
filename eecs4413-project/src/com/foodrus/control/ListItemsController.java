package com.foodrus.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.dao.jdbp.ItemDao;
import com.foodrus.util.Constants.ViewPath;

public class ListItemsController implements Controller {

	public ListItemsController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("items", new ItemDao().getAll());
		} catch (SQLException | NamingException e) {
			System.err.println("Could not retrieve Items from DAO");
			throw new ServletException(e);
		}
		return ViewPath.HOME;
	}

}
