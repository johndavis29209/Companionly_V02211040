package com.companionly.prototype.models;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public class LoginModel {
	
	
	@NotNull(message = "Email is required")
	@Email(message = "Please provide a valid email address")
	@Size(max = 50, message = "Email must be less than 50 characters")

	private String email;
	
	@NotNull(message = "Password is required")
	@Size(min =8, max = 15, message = "Password must be between 8-15 characters")
	private String password;
	
	
	
	public LoginModel() {
		super();
	
	}
	
	public LoginModel(String email, String password) {
        super();
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
	
	@Override
    public String toString() {
        return "LoginModel [email=" + email + ", password=" + password + "]";
    }
}

