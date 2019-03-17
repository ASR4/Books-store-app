package com.cnb.service;

import java.util.List;

import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.Order;
import com.cnb.domain.ShoppingCart;

public interface CartItemService {
	List<CartItem> findListOfCartFromShoppingCart();
	
//	CartItem updateCartItem(CartItem cartItem);
	CartItem updateCartItem(CartItem cartItem, ShoppingCart shoppingCart);
	
	CartItem addItemSkuToCartItem(ItemSku itemSku, CnbUser user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
//	List<CartItem> findByOrder(Order order);
	
	ShoppingCart getShoppingCart();

	void setShoppingCart(ShoppingCart shoppingCart);

}
