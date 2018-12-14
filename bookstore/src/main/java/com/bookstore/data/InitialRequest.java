package com.bookstore.data;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class InitialRequest {
	
	CNBData cnbData ;

	public CNBData getCnbData() {
		return cnbData;
	}

	public void setCnbData(CNBData cnbData) {
		this.cnbData = cnbData;
	}
	
	
}