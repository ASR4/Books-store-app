package com.cnb.domain;

//@Component
//@Scope("request")
public class InitialRequest {
	
	CNBData cnbData ;

	public CNBData getCnbData() {
		return cnbData;
	}

	public void setCnbData(CNBData cnbData) {
		this.cnbData = cnbData;
	}
	
	
}