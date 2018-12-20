package com.cnb.domain;

public class ItemSkuToCartItem {

	private Long id;
	private ItemSku itemSku;
	private CartItem cartItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemSku getItemSku() {
		return itemSku;
	}

	public void setItemSku(ItemSku itemSku) {
		this.itemSku = itemSku;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
}
