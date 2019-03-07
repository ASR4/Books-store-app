package com.cnb.service.impl;

import java.util.List;

import com.bookstore.domain.Order;
import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.ShoppingCart;
import com.cnb.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem addBookToCartItem(ItemSku itemSku, CnbUser user, int qty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartItem save(CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItem> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
