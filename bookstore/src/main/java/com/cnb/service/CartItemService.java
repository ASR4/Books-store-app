package com.cnb.service;

import java.util.List;

import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.Order;
import com.cnb.domain.ShoppingCart;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addItemSkuToCartItem(ItemSku itemSku, CnbUser user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
//	List<CartItem> findByOrder(Order order);
	
	List<ShoppingCart> getListOfShoppingCart();

	void setListOfShoppingCart(List<ShoppingCart> listOfShoppingCart);
}
