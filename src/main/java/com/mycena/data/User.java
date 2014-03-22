/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycena.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Represents a user in our system.
 *
 * <p>
 * In a real system use {@link PasswordEncoder} to ensure the password is secured
 * properly. This demonstration does not address this due to time restrictions.
 * </p>
 *
 * @author Rob Winch
 */
@Entity
public class User {
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
    
    private String role;

    public User() {}

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.account = user.account;
        this.password = user.password;
        this.email = user.email;
        this.phone = user.phone;
        this.address = user.address;  
        this.role = user.role;
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
	public String getRole() {return role;}
	public void setRole(String role) {this.role = role;}
    
    
 /*   public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }
    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }
    public String getFirstName() {       return firstName;    }
    public void setFirstName(String firstName) {        this.firstName = firstName;    }
    public String getLastName() {        return lastName;    }
    public void setLastName(String lastName) {       this.lastName = lastName;    }
    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }*/
}