package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class UserBean {

	@Id
	String username;  //username 


	
	String role;
//	String email;
	String password; //password 
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
