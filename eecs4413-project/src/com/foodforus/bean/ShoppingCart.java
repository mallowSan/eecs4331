package com.foodforus.bean;

import java.util.List;

public class ShoppingCart implements java.io.Serializable{
	// *** Serial number
	private static final long serialVersionUID = 7421082833333095713L;

	private List<ShoppingItem> items;
	
	public ShoppingCart() {
		
	}

	public List<ShoppingItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingItem> items) {
		this.items = items;
	}
}
