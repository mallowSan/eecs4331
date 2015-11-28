package com.foodrus.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrus.bean.ShoppingCart;
import com.foodrus.bean.ShoppingItem;
import com.foodrus.bean.validate.ShoppingItemValidator;
import com.foodrus.util.Constants.ServletAttribute;
import com.foodrus.util.Constants.ViewPath;

public class AddItemController implements Controller {

	public AddItemController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ShoppingItem shoppingItem = new ShoppingItem();
		shoppingItem.setQty(request.getParameter("quantity"));
		ShoppingItemValidator validator = new ShoppingItemValidator();
		List<String> errors = validator.validate(shoppingItem);
		if(errors == null || errors.isEmpty()){
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(ServletAttribute.CART);
			if(cart == null){
				cart = new ShoppingCart();
				request.getSession().setAttribute(ServletAttribute.CART, cart);
			}
			cart.addItem(shoppingItem);
		} else {
			request.setAttribute(ServletAttribute.ERRORS, errors);
		}
		return ViewPath.CART;
	}
}
