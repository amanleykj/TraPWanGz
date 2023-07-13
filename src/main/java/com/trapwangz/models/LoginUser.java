package com.trapwangz.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message = "Your email is required here.")
	@Email(message = "Please enter a valid email.")
	private String email;
	
	@NotEmpty(message = "Password is required here.")
	@Size(min = 8, max = 128, message = "Your correct password is required here.")
	private String password;
	
	public LoginUser() {}
	
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
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

}
