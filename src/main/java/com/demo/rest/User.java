package com.demo.rest;

public class User{
	
	private int userId;
	private String userName; 
	private String password;
    private String userEmail;
    private String role;
	private String userNumber;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getRole() {
		return role;
	}
	public String getUserNumber() {
		return userNumber;
	}
	
	
    
}
