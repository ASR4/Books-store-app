package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.domain.ItemSku;
import com.cnb.service.ItemSkuService;
import com.cnb.service.TaskData; 

@Service
public class ItemSkuServiceImpl implements ItemSkuService {
	@Autowired
	private TaskData taskData;
	
	Map<String, ItemSku> idCatalogMap = new HashMap<>();
	
	@Override
	public void setIdCatalogMap() {
		List<ItemSku> catalogList = findAll();
		
		for(ItemSku item : catalogList) {
			if(item!=null) {
//				System.out.println("[DEBUG] ItemSkuServiceImpl : MasterSKU : " + item.getMasterSKU());
				idCatalogMap.put(item.getMasterSKU(), item);
			}
		}
//		System.out.println("[DEBUG] ItemSkuServiceImpl: Map : " + idCatalogMap);
	}
	
	@Override
	public ItemSku findOne(String masterSKU) {
		return this.idCatalogMap.get(masterSKU);		
	}
	

	@Override
	public List<ItemSku> findAll() {
		List<ItemSku> catalogList = taskData.getInitialRequest().getCnbData().getItemSkuList();		
		return catalogList;
	}

	@Override
	public List<ItemSku> findByCategory(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemSku> blurrySearch(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
