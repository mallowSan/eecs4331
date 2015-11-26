package com.foodrus.bean;

public class ShoppingItem implements DomainBean {
	// *** Serial Number
	private static final long serialVersionUID = -7514811715857864868L;
	
	private Item item;
	private int qty;
	
	public ShoppingItem() {

	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
