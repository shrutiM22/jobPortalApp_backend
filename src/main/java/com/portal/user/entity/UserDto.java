package com.portal.user.entity;

public class UserDto {
	
	private String email;
	private String password;
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getemail() {
		return email;
	}

}
