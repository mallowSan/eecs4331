package com.foodrus.dao.jdbp;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.foodrus.bean.DomainBean;
import com.foodrus.dao.GenericDao;
import com.foodrus.util.Constants.DAO;

public abstract class GenericDaoJdbc<T extends DomainBean> implements GenericDao<T>{

	private Class<T> clazz; 
	private DataSource dataSource;
	
	public GenericDaoJdbc(Class<T> clazz) throws NamingException {
		this.clazz = clazz;
		dataSource = InitialContext.doLookup(DAO.JNDI_NAME);
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
