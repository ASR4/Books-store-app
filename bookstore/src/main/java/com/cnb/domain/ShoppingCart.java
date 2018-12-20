package com.cnb.domain;

import java.util.List;

public class ShoppingCart {
	private List<CartItem> listOfCartItems;
	
	public List<CartItem> getListOfCartItems() {
		return listOfCartItems;
	}
	public void setListOfCartItems(List<CartItem> listOfCartItems) {
		this.listOfCartItems = listOfCartItems;
	}	
	
}
