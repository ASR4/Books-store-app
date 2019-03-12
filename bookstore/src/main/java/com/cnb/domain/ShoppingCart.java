package com.cnb.domain;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {	
	private Long id;
	private BigDecimal GrandTotal;
	private List<CartItem> cartItemList;
	private CnbUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public CnbUser getUser() {
		return user;
	}

	public void setUser(CnbUser user) {
		this.user = user;
	}
	
}
