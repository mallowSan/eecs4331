package com.foodrus.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.dao.jdbp.ItemDao;
import com.foodrus.util.Constants.ServletAttribute;
import com.foodrus.util.Constants.ViewPath;

public class SearchController implements Controller {

	public SearchController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = ViewPath.HOME;
		String keyword = request.getParameter("searchText");
		if(keyword != null && !keyword.trim().isEmpty()){
			try {
				request.setAttribute(ServletAttribute.SEARCH_RESULT,
						(new ItemDao()).getItemsWithKeyWord(keyword));
				view = ViewPath.SEARCH;
			} catch (NamingException | SQLException e) {
				throw new ServletException("Dao Exception was thrown", e);
			}
		}
		return view;
	}
}
