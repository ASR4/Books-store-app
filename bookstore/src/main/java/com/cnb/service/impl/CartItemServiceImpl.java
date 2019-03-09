package com.cnb.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bookstore.domain.BookToCartItem;
import com.bookstore.domain.Order;
import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.ItemSkuToCartItem;
import com.cnb.domain.ShoppingCart;
import com.cnb.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	Map<CnbUser, ShoppingCart> userShoppingCartMap = new HashMap<CnbUser, ShoppingCart>();
	
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
	public CartItem addItemSkuToCartItem(ItemSku itemSku, CnbUser user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if(itemSku.getMasterSKU() == cartItem.getItemSku().getMasterSKU()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(itemSku.getPrice_CAD()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setBook(itemSku);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(itemSku.getPrice_CAD()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
		
		ItemSkuToCartItem itemSkuToCartItem = new ItemSkuToCartItem();
		itemSkuToCartItem.setItemSku(itemSku);
		itemSkuToCartItem.setCartItem(cartItem);
		itemSkuToCartItem.save(bookToCartItem);
		
		return cartItem;
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
