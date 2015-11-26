package com.foodrus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodrus.bean.DomainBean;

public abstract class RowMapper<T extends DomainBean> {
	
	public RowMapper() {
		super();
	}
	
	public abstract T mapRow(ResultSet resultSet, int rowNumber) throws SQLException; 
}
