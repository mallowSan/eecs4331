package com.foodrus.dao;

import java.sql.SQLException;
import java.util.List;

import com.foodrus.bean.DomainBean;

public interface GenericDao<T extends DomainBean> {
	/**
	 * Get domainBean by primary key(s)
	 * @param pks primary key(s)
	 * @return the bean
	 */
	T get(Object... pks) throws SQLException;
	
	/**
	 * Get all domainBean in a table
	 * @return list of bean
	 */
	List<T> getAll() throws SQLException;
}
