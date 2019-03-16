package com.cnb.service;

import java.util.List;

import com.cnb.domain.CartItem;
import com.cnb.domain.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart, List<CartItem> cartItemList);
	
	void clearShoppingCart(ShoppingCart shoppingCart);
}
