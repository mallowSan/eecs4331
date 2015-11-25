package com.foodrus.util;

import java.util.HashMap;
import java.util.Map;

import com.foodrus.control.*;

public class Constants {
	
	// *** utility class
	private Constants() {
	}

	// *** ServletAttributes constants
	public static final class ServletAttribute {
		public static final String SOUCE = "com.foodrus.util.source";
		public static final String TARGET = "com.foodrus.util.target";
		public static final String CART = "com.foodrus.util.cart";
		public static final String LOGGED_IN = "com.foodrus.util.loggedIn";
		public static final String LOGGED_OUT = "com.foodrus.util.loggedOut";
	}

	// *** ServletAttributes constants
	public static final class ViewPath {
		public static final String DASH_BOARD = "/WEB-INF/jsp/Dashboard.jsp";
		public static final String CART = "/WEB-INF/jsp/Cart.jsp";
		public static final String HOME = "/WEB-INF/jsp/Home.jsp";
		public static final String LOGIN = "/WEB-INF/jsp/Login.jsp";
		public static final String CHECK_OUT = "/WEB-INF/jsp/Checkout.jsp";
	}
	
	// *** URL constants
	public static final class Url {
		public static final String SEPARATOR = "/";
	}

	// *** Resource constants
	public static final class Resource {
		public static final String LOGIN = "/login";
		public static final String HOME = "/home";
		public static final String ADD_ITEM = "/additem";
		public static final String REMOVE_ITEM = "/removeitem";
		public static final String CHECK_OUT = "/checkout";
		public static final Map<String, Controller> RESOURCE_MAP = new HashMap<>();
		static{
			RESOURCE_MAP.put(LOGIN, new LoginController());
			RESOURCE_MAP.put(HOME, new HomeController());
			RESOURCE_MAP.put(ADD_ITEM, new AddItemController());
			RESOURCE_MAP.put(REMOVE_ITEM, new RemoveItemController());
			RESOURCE_MAP.put(CHECK_OUT, new CheckOutController());
		}
	}
	
	// *** HTTP methods names
	public static final class HttpMethod{
		public static final String GET = "GET";
		public static final String POST = "POST";
	}
	
	// ** DAO constants
	public static final class DAO{
		public static final String JNDI_NAME = "java:/comp/env/jdbc/EECS";
	}
}
