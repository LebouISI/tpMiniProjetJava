package com.samanecorp.secureapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AccountUserEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "email", length = 200, nullable = false, unique = true)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	private boolean state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AccountUserEntity(long id, String email, String password, boolean state) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.state = state;
	}
	
	public AccountUserEntity() {
		super();
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

}
