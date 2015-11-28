package com.foodrus.beans;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.foodrus.bean.ShoppingCart;
import com.foodrus.bean.ShoppingItem;
import com.foodrus.bean.vo.Item;

public class ShoopingCartTest {
	
	private static List<Item> dummyItems;

	@BeforeClass
	public static void init() {
		Random rand = new Random();
		dummyItems = new ArrayList<>();
		for(int i=0; i<10; i++){
			Item item = new Item();
			if(i % 2 == 0){
				item.setNumber("2");
			} else{
				item.setNumber(i+"");
			}
			item.setCatId(i);
			item.setPrice(i);
			item.setName("item_" + i);
			item.setQty(rand.nextInt(100));
			dummyItems.add(item);
		}
	}
	
	@Test
	public void testAdd() {
		ShoppingCart cart = new ShoppingCart(); 
		cart.addItem(new ShoppingItem(dummyItems.get(0), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(2), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(4), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(6), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(8), "1"));
		printCart(cart);
		assertFalse("Cart should not be empty", cart.getItems().isEmpty());
		assertEquals("Cart should have 1 item", cart.getItems().size(), 1);
		assertEquals("item_0 should have qty of 5", cart.getItems().iterator().next().getQty(), "5");
		
		cart.addItem(new ShoppingItem(dummyItems.get(2), null));
		cart.addItem(new ShoppingItem(dummyItems.get(2), "not Integer"));
		printCart(cart);
		assertEquals("item_0 should still be 5 qty", cart.getItems().iterator().next().getQty(), "5");
	}

	@Test
	public void testUpdate() {
		ShoppingCart cart = new ShoppingCart(); 
		cart.addItem(new ShoppingItem(dummyItems.get(7), "4413"));
		printCart(cart);
		assertEquals("item_7 should have 1 as qty", cart.getItems().iterator().next().getQty(), "4413");
		
		cart.updateItem(new ShoppingItem(dummyItems.get(7), "100"));
		printCart(cart);
		assertEquals("item_7 should have updated qty to 100", cart.getItems().iterator().next().getQty(), "100");
	}

	@Test
	public void testRemove() {
		ShoppingCart cart = new ShoppingCart(); 
		cart.addItem(new ShoppingItem(dummyItems.get(0), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(6), "10"));
		cart.addItem(new ShoppingItem(dummyItems.get(3), "1"));
		cart.addItem(new ShoppingItem(dummyItems.get(5), "1"));
		cart.addItem(null);
		printCart(cart);
		assertEquals("Cart should have 2 items", cart.getItems().size(), 3);

		cart.removeItem(dummyItems.get(8));
		printCart(cart);
		assertEquals("Cart should have 2 items", cart.getTotalItems(), 2);

		for(Item item : dummyItems){
			cart.addItem(new ShoppingItem(item, "12"));
		}
		printCart(cart);
		assertEquals("Cart should have 6 items", cart.getItems().size(), 6);
		cart.emptyCart();
		printCart(cart);
		assertTrue("Cart should be empty after calling emptyCart()", cart.getItems().isEmpty());
	}
	
	@Test
	public void testComputation(){
		ShoppingCart cart = new ShoppingCart(); 
		cart.addItem(new ShoppingItem(dummyItems.get(1), "1")); //
		cart.addItem(new ShoppingItem(dummyItems.get(2), "2"));
		cart.addItem(new ShoppingItem(dummyItems.get(3), "3"));
		cart.addItem(new ShoppingItem(dummyItems.get(5), "5"));
		cart.addItem(new ShoppingItem(dummyItems.get(9), "9"));
		
		printCart(cart);
		// sum of qty of each (ShoppingItem.qty)
		assertTrue("Total Qty should be 20", cart.getTotalItems() == 20); 
		// distinct (ShoppingItems) in cart
		assertTrue("items count is actually 5", cart.getItems().size() == 5); 
		// sum of (ShoppingItem.PriceBeforeTax()), where 
		// ShoppingItem.PriceBeforeTax() is (ShoppingItem.Item.price * ShoppingItem.qty)  
		assertTrue("Cart Total Price before Tax is $120.00",
				Double.compare(cart.getTotalPriceBeforeTax(), 120d) == 0); 
	}
	
	@Ignore
	private void printCart(		ShoppingCart cart ) {
		System.out.println("\n-------- printing cart start --------");
		for(ShoppingItem si : cart.getItems()){
			System.out.println("\t - item [" + si.getItem().getName() + "] --> qty ["+si.getQty()+"]");
		}
		System.out.println("\n***** printing cart end *****");
	}
}
