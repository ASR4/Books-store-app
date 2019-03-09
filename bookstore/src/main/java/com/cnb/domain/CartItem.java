package com.cnb.domain;

import java.math.BigDecimal;
import java.util.List;

public class CartItem {

	private Long id;
	private int qty;
	private BigDecimal subtotal;
	private ItemSku itemSku;
	private List<ItemSkuToCartItem> itemSkuToCartItemList;
	private ShoppingCart shoppingCart;
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public ItemSku getItemSku() {
		return itemSku;
	}

	public void setItemSku(ItemSku itemSku) {
		this.itemSku = itemSku;
	}

	public List<ItemSkuToCartItem> getItemSkuToCartItemList() {
		return itemSkuToCartItemList;
	}

	public void setItemSkuToCartItemList(List<ItemSkuToCartItem> itemSkuToCartItemList) {
		this.itemSkuToCartItemList = itemSkuToCartItemList;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
