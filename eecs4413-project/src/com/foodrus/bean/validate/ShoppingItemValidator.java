package com.foodrus.bean.validate;

import java.util.ArrayList;
import java.util.List;

import com.foodrus.bean.DomainBean;
import com.foodrus.bean.ShoppingItem;

public class ShoppingItemValidator implements Validator{

	public ShoppingItemValidator() {
		super();
	}

	@Override
	public List<String> validate(DomainBean form) {
		ShoppingItem shoppingItem = (ShoppingItem) form;
		List<String> errors = null;
		if(shoppingItem != null){
			errors = new ArrayList<>();
			String qty = shoppingItem.getQty();
			if(qty == null || qty.trim().isEmpty()){
				errors.add("Quantity can not be empty!");
			} else {
				int qtyAsInt = -1;
				try{
					qtyAsInt = Integer.parseInt(qty, 10);
					if(qtyAsInt < 0){
						errors.add("Quantity must be positive number!");
					}
				} catch(Exception e){
					errors.add("Quantity must be number!");
				}
			}
		}
		return errors;
	}
}