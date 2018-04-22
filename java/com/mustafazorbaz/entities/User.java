package com.mustafazorbaz.entities;

public class User {
	private String email;
	private String password;
	private String token;
	private String status;
	public User()
	{
	}
	
	public User(String email, String password, String token, String status) {
		super();
		this.email = email;
		this.password = password;
		this.token = token;
		this.status = status;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
