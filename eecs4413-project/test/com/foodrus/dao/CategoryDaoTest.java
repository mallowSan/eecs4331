package com.foodrus.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;

import com.foodrus.bean.vo.Category;
import com.foodrus.dao.jdbp.CategoryDao;

public class CategoryDaoTest extends GenericDaoTest{
	private static CategoryDao dao;
	
	@BeforeClass
	public void initDao(){
		dao = new CategoryDao(dataSource);
		assertNotNull("dao is null", dao);
	}
	
	@Override
	public void getTest() {
		Category cat = null;
		try {
			cat = dao.get("5");
		} catch (SQLException e) {
			fail("could not Category from getById: " + e.getMessage());
		}
		assertNotNull("Category is null: ", cat);
		System.out.println(cat);
	}

	@Override
	public void getAllTest() {
		List<Category> cats = null;
		try {
			cats = dao.getAll();
		} catch (SQLException e) {
			fail("could not getAll categories: " + e.getMessage());
		}
		assertNotNull("categories is null: ", cats);
		assertFalse("categories list should not empty", cats.isEmpty());
		assertNotNull("first category should not be null", cats.get(0));
		System.out.println(cats.get(0));

	}
}
