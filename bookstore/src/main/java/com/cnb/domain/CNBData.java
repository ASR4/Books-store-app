package com.cnb.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CNBData {
	
	private static UserDetails userDetails;
	private static List<ItemSku> itemSkuList = new ArrayList<>();
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<ItemSku> getItemSkuList() {
		return itemSkuList;
	}
	public void setItemSkuList(List<ItemSku> itemSkuList) {
		this.itemSkuList = itemSkuList;
	}
	
	

}
