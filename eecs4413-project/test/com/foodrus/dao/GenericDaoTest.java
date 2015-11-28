package com.foodrus.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.apache.derby.jdbc.ClientDataSource;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class GenericDaoTest {
	
	protected static ClientDataSource dataSource;
	
	@BeforeClass
	public static void init(){
		dataSource = new ClientDataSource();
		dataSource.setServerName("roumani.eecs.yorku.ca");
		dataSource.setDatabaseName ("CSE");
		dataSource.setPortNumber(64413);
		dataSource.setUser("student");
		dataSource.setPassword("secret");
		assertNotNull("dataSource is null", dataSource);
		try {
			assertNotNull("Connection is null", dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("could not get connection: " + e.getMessage());
		}
	}
	
	@Test
	public abstract void getTest();

	@Test
	public abstract void getAllTest();

}
