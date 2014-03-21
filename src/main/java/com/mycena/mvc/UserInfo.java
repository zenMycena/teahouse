package com.mycena.mvc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mycena.data.User;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserInfo implements Serializable{
	private static final long serialVersionUID = -4272778060638125475L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name is required.")
    private String name;    
    @NotEmpty(message = "Account is required.")
    @Column(unique=true, nullable = false)
    private String account;
    @NotEmpty(message = "Password is required.")
    private String password;
    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    @Column(unique=true, nullable = false)
    private String email;
    @NotEmpty(message = "Phone is required.")
    private String phone;
    @NotEmpty(message = "Address is required.")
    private String address;
    
    public UserInfo() {}

    public UserInfo(UserInfo user) {
        this.id = user.id;
        this.name = user.name;
        this.account = user.account;
        this.password = user.password;
        this.email = user.email;
        this.phone = user.phone;
        this.address = user.address;       
    }

	public Long getId() {		return id;	}
	public void setId(Long id) {		this.id = id;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getAccount() {		return account;	}
	public void setAccount(String account) {		this.account = account;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public String getAddress() {		return address;	}
	public void setAddress(String address) {		this.address = address; }
}
