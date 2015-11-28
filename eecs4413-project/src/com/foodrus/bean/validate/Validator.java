package com.foodrus.bean.validate;

import java.util.List;

import com.foodrus.bean.DomainBean;

public interface Validator {
	/**
	 * This method add a common validation for a Form. 
	 * @param form to be validated
	 * @return List of errors in case validation failed
	 */
	List<String> validate(DomainBean form);
}
