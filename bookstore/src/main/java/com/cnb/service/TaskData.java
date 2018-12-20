package com.cnb.service;

import org.springframework.stereotype.Component;

import com.cnb.domain.InitialRequest;
import com.cnb.domain.CnbUser;

@Component
public class TaskData {

	private InitialRequest initialRequest;
	private CnbUser user;
	
	public InitialRequest getInitialRequest() {
		return initialRequest;
	}
	public void setInitialRequest(InitialRequest initialRequest) {
		this.initialRequest = initialRequest;
	}
	public CnbUser getUser() {
		return user;
	}
	public void setUser(CnbUser user) {
		this.user = user;
	}
	
	
	
	
}
