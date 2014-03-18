package com.mycena.mvc;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	@NotEmpty(message = "name is required.")
    private String name;

    @NotEmpty(message = "account is required.")
    private String account;
    
    @NotEmpty(message = "account is required.")
    private String password;
    
    @NotEmpty(message = "account is required.")
    private String address;
    
    @NotEmpty(message = "account is required.")
    private String phone;
    
    @NotEmpty(message = "account is required.")
    private String email;

	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getAccount() {		return account;	}
	public void setAccount(String account) {		this.account = account;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public String getAddress() {		return address;	}
	public void setAddress(String address) {		this.address = address;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) { this.phone = phone;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	} 
	
    
}
