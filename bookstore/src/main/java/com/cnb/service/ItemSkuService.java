package com.cnb.service;

import java.util.List;

import com.cnb.domain.ItemSku;

public interface ItemSkuService {

	List<ItemSku> findAll ();
	
	//ItemSku findOne(Long id); // there is no id for the item sku
//	List<ItemSku> findByCategory(String category); // sku doesnot have category
//	List<ItemSku> blurrySearch(String title);// sku doesnot have title
	
	List<ItemSku> findByCategory(String brand);
	List<ItemSku> blurrySearch(String type);
}


