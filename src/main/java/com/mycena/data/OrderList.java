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
	private double totalPrice;
	private Date orderDate;
	private int status;
/*	@OneToMany(mappedBy="orderList")
    private Set<Orders> orders;*/
	private UUID uid;
	
	public long getId() {		return id;	}
	public void setId(long id) {		this.id = id;	}
	public String getUsername() {		return username;	}
	public void setUsername(String username) {		this.username = username;	}
	public double getTotalPrice() {		return totalPrice;	}
	public void setTotalPrice(double totalPrice) {		this.totalPrice = totalPrice;	}
	public Date getOrderDate() {		return orderDate;	}
	public void setOrderDate(Date orderDate) {		this.orderDate = orderDate;	}
	public int getStatus() {		return status;	}
	public void setStatus(int status) {		this.status = status;	}
/*	public Set<Orders> getOrders() {		return orders;	}
	public void setOrders(Set<Orders> orders) {		this.orders = orders;	}*/
	public UUID getUid() {
		return uid;
	}
	public void setUid(UUID uid) {
		this.uid = uid;
	}
	
	
}
