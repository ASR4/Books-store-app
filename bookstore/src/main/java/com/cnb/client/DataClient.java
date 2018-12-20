package com.cnb.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cnb.domain.CNBData;
import com.cnb.domain.CnbUser;
import com.cnb.domain.InitialRequest;
import com.cnb.service.TaskData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * To be called when user clicks through the cnb button. That triggers a 
 * new controller(CNB controller) on our side. This controller than triggers this
 * class i.e DataClient
 * @author Ashmeet
 *
 */

@Component
public class DataClient {

	//call the endpoint to get the json from the server

	 private InitialRequest initialRequest;
	 private CNBData cnbData;
	 private CnbUser user;
	 
	 @Autowired
	 private TaskData taskData;
	 
	/*JSON response 
	 * {
				  "itemSkuList":
				  [
				    { "masterSKU":"Ford", 
				       "product":"car" 
				    },
				    {
				      "masterSKU":"Mustang", 
				      "product":"bike"
				    }
				    
				  ],
				    "userDetails":
				    {
				      "name": "Maitri", 
				      "address": "payne"
				    }
				}
	*/
	 
	 public void getJson() {
		//TODO make client call	
	 }
	
	 public void readCnbJson(String gsonResponse) throws JsonParseException, JsonMappingException, IOException {
		if(gsonResponse!=null && gsonResponse.length() !=0){
			ObjectMapper mapper = new ObjectMapper();
			this.cnbData = mapper.readValue(gsonResponse, CNBData.class);
			System.out.println("[DEFAULT] : " + cnbData.getItemSkuList().get(0).getMasterSKU());
			System.out.println("[DEFAULT] : " + cnbData.getUserDetails().getUserName());
			
		}
	 }
	 
	 public void fillInitialRequest() {
		 this.initialRequest = new InitialRequest();
		 this.initialRequest.setCnbData(cnbData);
	 }
	 
	 public void fillCnbUser() {
		 this.user = new CnbUser();
		 this.user.setUserDetails(this.initialRequest.getCnbData().getUserDetails());
	 }
	 
	 public void fillTaskData() {
		this.taskData.setUser(user);
		this.taskData.setInitialRequest(initialRequest);
		
	 }

}
