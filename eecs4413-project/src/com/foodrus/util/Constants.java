package com.foodrus.util;

import java.util.Collections;
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
		private static final Map<String, Controller> res_map = new HashMap<>();
		static{
			res_map.put(LOGIN, new LoginController());
			res_map.put(HOME, new HomeController());
			res_map.put(ADD_ITEM, new AddItemController());
			res_map.put(REMOVE_ITEM, new RemoveItemController());
			res_map.put(CHECK_OUT, new CheckOutController());
		}
		public static final Map<String, Controller> RESOURCE_MAP = Collections.unmodifiableMap(res_map);
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
