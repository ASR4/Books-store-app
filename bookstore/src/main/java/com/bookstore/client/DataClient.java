package com.bookstore.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.data.CNBData;
import com.bookstore.data.InitialRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataClient {

	//call the endpoint to get the json from the server
	
	String gsonResponse = "{  \r\n   \"itemSkuList\":[  \r\n      {  \r\n         \"masterSKU\":\"Ford\",\r\n         \"product\":\"car\"\r\n      },\r\n      {  \r\n         \"masterSKU\":\"Mustang\",\r\n         \"product\":\"bike\"\r\n      }\r\n   ],\r\n   \"userDetails\":{  \r\n      \"name\":\"Maitri\",\r\n      \"address\":\"payne\"\r\n   }\r\n}";
		
	 @Autowired
	    private InitialRequest initialRequest;
	
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
	
	public void fillData() throws JsonParseException, JsonMappingException, IOException {
		if(gsonResponse!=null && gsonResponse.length() !=0){
			ObjectMapper mapper = new ObjectMapper();
			CNBData cnbData = mapper.readValue(gsonResponse, CNBData.class);
			 initialRequest.setCnbData(cnbData);
		}
	}
	

}
