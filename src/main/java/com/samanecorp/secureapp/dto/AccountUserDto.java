package com.samanecorp.secureapp.dto;

public class AccountUserDto {
	
	private long id;
	private String email;
	private String password;
	private boolean state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public AccountUserDto(long id, String email, boolean state) {
		super();
		this.id = id;
		this.email = email;
		this.state = state;
	}
	public AccountUserDto() {
		super();
	}

}
