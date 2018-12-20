package com.cnb.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.domain.ItemSku;
import com.cnb.service.ItemSkuService;
import com.cnb.service.TaskData; 

@Service
public class ItemSkuServiceImpl implements ItemSkuService {

	@Autowired
	private TaskData taskData;

	@Override
	public List<ItemSku> findAll() {
		List<ItemSku> catagoryList = taskData.getInitialRequest().getCnbData().getItemSkuList();		
		return catagoryList;
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
