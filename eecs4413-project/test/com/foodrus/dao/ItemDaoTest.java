package com.foodrus.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.foodrus.bean.Item;
import com.foodrus.dao.jdbp.ItemDao;

public class ItemDaoTest {
	ItemDao dao;
	
	@Before
	public void init() {
		try {
			dao = new ItemDao();
		} catch (NamingException e) {
			System.err.println("could not initlize Item DAO ");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAll() throws SQLException{
		assertNotNull("dao not initilized", dao);
		List<Item> allItems = dao.getAll();
		assertNotNull("getAll returned null !!", allItems);
		assertFalse("getAll returned null !!", allItems.isEmpty());
		for(Item i : allItems){
			System.out.println(i);
		}
	}
}
