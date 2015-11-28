package com.foodrus.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foodrus.bean.vo.Item;
import com.foodrus.dao.jdbp.ItemDao;

public class ItemDaoTest extends GenericDaoTest{
	private static ItemDao dao;
	
	@BeforeClass
	public static void initDao(){
		dao = new ItemDao(dataSource);
		assertNotNull("dao is null", dao);
	}
	
	@Override
	public void getAllTest(){
		List<Item> items = null;
		try {
			items = dao.getAll();
		} catch (SQLException e) {
			fail("could not getAll items: " + e.getMessage());
		}
		assertNotNull("items is null: ", items);
		assertFalse("items list should not empty", items.isEmpty());
		assertNotNull("first Item should not be null", items.get(0));
		System.out.println(items.get(0));
	}
	
	@Override
	public void getTest(){
		Item item = null;
		try {
			item = dao.get("1409S737");
		} catch (SQLException e) {
			fail("could not getById: " + e.getMessage());
		}
		assertNotNull("item is null: ", item);
		System.out.println(item);
	}

	@Test
	public void testByKeyWord(){
		List<Item> itemsWith_meat = null;
		List<Item> itemsWith_MEAT = null;
		try {
			itemsWith_meat = dao.getItemsWithKeyWord("meat");
			itemsWith_MEAT = dao.getItemsWithKeyWord("MEAT");
		} catch (SQLException e) {
			fail("could not getItemsWithKeyWord items: " + e.getMessage());
		}
		assertNotNull("itemsWith_meat is null: ", itemsWith_meat);
		assertNotNull("itemsWith_MEAT is null: ", itemsWith_MEAT);
		assertFalse("items list should not empty", itemsWith_meat.isEmpty());
		assertFalse("items list should not empty", itemsWith_MEAT.isEmpty());
		Collections.sort(itemsWith_meat, new  Comparator<Item>(){
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getNumber().compareTo(o2.getNumber());
			}
		});
		Collections.sort(itemsWith_MEAT, new  Comparator<Item>(){
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getNumber().compareTo(o2.getNumber());
			}
		});
		assertTrue("searching with[meat] and [MEAT] should yeild the same result",
				equalLists(itemsWith_meat, itemsWith_MEAT));
		for(Item item : itemsWith_meat){
			System.out.println(item);
		}
	}

	private boolean equalLists(List<Item> items1, List<Item> items2) {
		boolean equals = true;
		for(int i=0; equals && i<items1.size(); i++){
			equals = items1.get(i).getNumber().
					equals(items2.get(i).getNumber());
		}
		return equals;
	}
}