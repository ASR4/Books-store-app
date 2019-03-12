package com.cnb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.domain.CartItem;
import com.cnb.domain.ShoppingCart;
import com.cnb.service.CartItemService;
import com.cnb.service.ShoppingCartService;

@Service
public class ShoppingCartServiceCnbImpl implements ShoppingCartService{
	
	@Autowired
	private CartItemService cartItemService;
	
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		if(cartItemService.getListOfShoppingCart().contains(shoppingCart)) {
			cartItemService.getListOfShoppingCart().remove(shoppingCart);
		}
		
		BigDecimal cartTotal = new BigDecimal(0);
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			if(cartItem.getItemSku().getInventory() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
		}
		
		shoppingCart.setGrandTotal(cartTotal);
		
//		shoppingCartRepository.save(shoppingCart);
		List<ShoppingCart> listOfShoppingCart = cartItemService.getListOfShoppingCart();
		listOfShoppingCart.add(shoppingCart);
		
		return shoppingCart;
	}
	
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		if(cartItemService.getListOfShoppingCart().contains(shoppingCart)) {
			cartItemService.getListOfShoppingCart().remove(shoppingCart);
		}
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}
		
		shoppingCart.setGrandTotal(new BigDecimal(0));
		
//		shoppingCartRepository.save(shoppingCart);
		List<ShoppingCart> listOfShoppingCart = cartItemService.getListOfShoppingCart();
		listOfShoppingCart.add(shoppingCart);
	}

}

