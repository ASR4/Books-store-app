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
	
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart, List<CartItem> cartItemList) {
//		if(cartItemService.getListOfShoppingCart().contains(shoppingCart)) {
//			cartItemService.getListOfShoppingCart().remove(shoppingCart);
//		}
		
		BigDecimal cartTotal = new BigDecimal(0);
//		List<CartItem> cartItemList = cartItemService.findListOfCartFromShoppingCart();
		
		//TODO remove the print block
		System.out.println("[DEBUG] : In ShoppingCartServiceCnbImpl + cartItem list NOT empty");
		for(CartItem cartI : cartItemList) {
			System.out.println("[DEBUG] : master sku : " + cartI.getItemSku().getMasterSKU());
			System.out.println("[DEBUG] : quantity : " + cartI.getQty());
			System.out.println("[DEBUG] : inventory : " + cartI.getItemSku().getInventory());
//			System.out.println("[DEBUG] : shopping cart list : " + cartI.getShoppingCart().getCartItemList());
//			System.out.println("[DEBUG] : shopping cart list : " + cartI.getShoppingCart().getId());
		}
		
//		for (CartItem cItem : cartItemList) {		
//			if(cItem.getItemSku().getInventory() > 0) {
//				cartItemService.updateCartItem(cItem, shoppingCart);
//				cartTotal = cartTotal.add(cItem.getSubtotal());
//			}
//		}
		
		for (int i = 0; i < cartItemList.size(); i++) {		
			if(cartItemList.get(i).getItemSku().getInventory() > 0) {
				cartItemService.updateCartItem(cartItemList.get(i), shoppingCart);
				cartTotal = cartTotal.add(cartItemList.get(i).getSubtotal());
			}
		}
		
		shoppingCart.setGrandTotal(cartTotal);
		
//		shoppingCartRepository.save(shoppingCart);
		cartItemService.setShoppingCart(shoppingCart);
		
		return shoppingCart;
	}
	
	public void clearShoppingCart(ShoppingCart shoppingCart) {
//		if(cartItemService.getListOfShoppingCart().contains(shoppingCart)) {
//			cartItemService.getListOfShoppingCart().remove(shoppingCart);
//		}
		
		List<CartItem> cartItemList = cartItemService.findListOfCartFromShoppingCart();
		
		for (CartItem cItem : cartItemList) {
			cItem.setShoppingCart(null);
			cartItemService.save(cItem);
		}
		
		shoppingCart.setGrandTotal(new BigDecimal(0));
		
//		shoppingCartRepository.save(shoppingCart);
		cartItemService.setShoppingCart(shoppingCart);
	}

}

