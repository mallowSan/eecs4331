package com.foodrus.bean;

public class UserProfile implements DomainBean{
	// *** Serial number
	private static final long serialVersionUID = -1274934290428726643L;
	
	private String userName;
	
	public UserProfile() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
