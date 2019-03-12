package com.cnb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.ItemSkuToCartItem;
import com.cnb.domain.Order;
import com.cnb.domain.ShoppingCart;
import com.cnb.service.CartItemService;

@Service
public class CartItemServiceCnbImpl implements CartItemService {
	
//	Map<CnbUser, ShoppingCart> userShoppingCartMap = new HashMap<CnbUser, ShoppingCart>();
	List<CartItem> listOfCartItems = new ArrayList<CartItem>();
	List<ShoppingCart> listOfShoppingCart = new ArrayList<ShoppingCart>();
	List<ItemSkuToCartItem> listOfItemSkuToCartItem = new ArrayList<ItemSkuToCartItem>();
	List<Order> listOfOrders = new ArrayList<Order>();
	
	public List<ShoppingCart> getListOfShoppingCart() {
		return listOfShoppingCart;
	}

	public void setListOfShoppingCart(List<ShoppingCart> listOfShoppingCart) {
		this.listOfShoppingCart = listOfShoppingCart;
	}
	
	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		if(listOfShoppingCart.contains(shoppingCart)) {
			return shoppingCart.getCartItemList();
		}
		return null;
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		if(listOfCartItems.contains(cartItem)) {
			listOfCartItems.remove(cartItem);
		}
		BigDecimal bigDecimal = new BigDecimal(cartItem.getItemSku().getPrice_CAD()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		//cartItemRepository.save(cartItem);
		listOfCartItems.add(cartItem);
		
		return cartItem;
	}

	@Override
	public CartItem addItemSkuToCartItem(ItemSku itemSku, CnbUser user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		if(cartItemList != null) {
			for (CartItem cartItem : cartItemList) {
				if(itemSku.getMasterSKU() == cartItem.getItemSku().getMasterSKU()) {
					//Hardcoding cart id as this is not a persistent session
					cartItem.setId(1234L);
					cartItem.setQty(cartItem.getQty()+qty);
					cartItem.setSubtotal(new BigDecimal(itemSku.getPrice_CAD()).multiply(new BigDecimal(qty)));
					listOfCartItems.add(cartItem);
					//cartItemRepository.save(cartItem);
					return cartItem;
				}
			}
		}
		
		CartItem cartItem = new CartItem();
		//Hardcoding cart id as this is not a persistent session
		cartItem.setId(1234L);
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setItemSku(itemSku);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(itemSku.getPrice_CAD()).multiply(new BigDecimal(qty)));
		listOfCartItems.add(cartItem);
		//cartItem = cartItemRepository.save(cartItem);
		
		ItemSkuToCartItem itemSkuToCartItem = new ItemSkuToCartItem();
		itemSkuToCartItem.setItemSku(itemSku);
		itemSkuToCartItem.setCartItem(cartItem);
		listOfItemSkuToCartItem.add(itemSkuToCartItem);
		//itemSkuToCartItem.save(bookToCartItem);
		cartItem.setItemSkuToCartItemList(listOfItemSkuToCartItem);
		
		return cartItem;
	}

	@Override
	public CartItem findById(Long id) {
		for(CartItem cartItem : listOfCartItems) {
			if(cartItem.getId() == id) {
				return cartItem;
			}
		}
		return null;
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		if(listOfCartItems.contains(cartItem)) {
			listOfCartItems.remove(cartItem);
		}	
	}

	@Override
	public CartItem save(CartItem cartItem) {
		listOfCartItems.add(cartItem);
		return cartItem;
	}

//	@Override
//	public List<CartItem> findByOrder(Order order) {
//		for(Order orderFromList : listOfOrders) {
//			if(orderFromList == order) {
//				return orderFromList.getCartItemList();
//			}
//		}
//		return null;
//	}

}
