package com.foodforus.form.validator;

import java.util.List;

import com.foodforus.form.Form;

public interface Validator {
	/**
	 * This method add a common validation for a Form. 
	 * @param form to be validated
	 * @return List of errors in case validation failed
	 */
	List<String> validate(Form form);
}
