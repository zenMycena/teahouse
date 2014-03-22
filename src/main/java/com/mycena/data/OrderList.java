package com.mycena.data;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String account;
	private double totalPrice;
	private Date orderDate;
	private String status;
/*	@OneToMany(mappedBy="orderList")
    private Set<Orders> orders;*/
	private UUID uid;
	private String address;
	private String phone;
	private String email;
	private int prepareTime;
	private Date finishDate;
	
	public String getAccount() {		return account;	}
	public void setAccount(String account) {		this.account = account;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public Date getFinishDate() {		return finishDate;	}
	public void setFinishDate(Date finishDate) {		this.finishDate = finishDate;	}
	public long getId() {		return id;	}
	public void setId(long id) {		this.id = id;	}
	public String getUsername() {		return username;	}
	public void setUsername(String username) {		this.username = username;	}
	public double getTotalPrice() {		return totalPrice;	}
	public void setTotalPrice(double totalPrice) {		this.totalPrice = totalPrice;	}
	public Date getOrderDate() {		return orderDate;	}
	public void setOrderDate(Date orderDate) {		this.orderDate = orderDate;	}
	public String getStatus() {		return status;	}
	public void setStatus(String status) {		this.status = status;	}
/*	public Set<Orders> getOrders() {		return orders;	}
	public void setOrders(Set<Orders> orders) {		this.orders = orders;	}*/
	public UUID getUid() {		return uid;	}
	public void setUid(UUID uid) {		this.uid = uid;	}
	public String getAddress() {		return address;	}
	public void setAddress(String address) {		this.address = address;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public int getPrepareTime() {		return prepareTime;	}
	public void setPrepareTime(int prepareTime) {		this.prepareTime = prepareTime;	}
}
