package com.mycena.mvc;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.gemstone.gemfire.internal.cache.FilterProfile.interestType;
import com.mycena.data.Orders;


public class MenuItemForm {
	//@NotEmpty(message = "name is required.")
    private UUID id;
	
	//@NotEmpty(message = "name is required.")
    private String name;
    private double hotPrice;
    private double icePrice;
    private double price;
    private int minToPrepare; 
    private int totalPrepare; 
    private Date orderDate;
    private String status;
    private UUID uid;
    private String ice;
    private String sweetness;
    private int quantity;
    private int totalQuantity;
    private String username;
    List<Orders> orders;
    private String email;
    private String phone;
    private String address;
    private String tag;//
    private Date finishDate;
    private int recommend;//
    private int original; //
    private String account;
    
    
	public String getAccount() {		return account;	}
	public void setAccount(String account) {		this.account = account;	}
	public Date getFinishDate() {		return finishDate;	}
	public void setFinishDate(Date finishDate) {		this.finishDate = finishDate;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public String getAddress() {		return address;	}
	public void setAddress(String address) {		this.address = address;	}
	public List<Orders> getOrders() {		return orders;	}
	public void setOrders(List<Orders> orders) {		this.orders = orders;	}
	public double getPrice() {		return price;	}
	public void setPrice(double price) {		this.price = price;	}
	public int getQuantity() {		return quantity;	}
	public void setQuantity(int quantity) {		this.quantity = quantity;	}
	public String getUsername() {		return username;	}
	public void setUsername(String username) {		this.username = username;	}
	public String getSweetness() {		return sweetness;	}
	public void setSweetness(String sweetness) {		this.sweetness = sweetness;	}
	public String getIce() {		return ice;	}	
	public void setIce(String ice) {		this.ice = ice;	}
	public UUID getId() {		return id;	}
	public void setId(UUID id) {		this.id = id;	}
	public String getName() {	return name;	}
	public void setName(String name) throws UnsupportedEncodingException {		this.name = new String(name.getBytes("ISO-8859-1"),"UTF-8");	}
	public double getHotPrice() {		return hotPrice;	}
	public void setHotPrice(double hotPrice) {		this.hotPrice = hotPrice;	}
	public double getIcePrice() {		return icePrice;	}
	public void setIcePrice(double icePrice) {		this.icePrice = icePrice;	}
	public String getTag() {		return tag;	}
	public void setTag(String tag) {		this.tag = tag;	}
	public int getRecommend() {		return recommend;	}
	public void setRecommend(int recommend) {		this.recommend = recommend;	}
	public int getOriginal() {		return original;	}
	public void setOriginal(int original) {		this.original = original;	}
	public int getMinToPrepare() {		return minToPrepare;	}
	public void setMinToPrepare(int minToPrepare) {	this.minToPrepare = minToPrepare;	}
	public int getTotalPrepare() {		return totalPrepare;	}
	public void setTotalPrepare(int totalPrepare) {		this.totalPrepare = totalPrepare;	}
	public Date getOrderDate() {		return orderDate;	}
	public void setOrderDate(Date orderDate) {		this.orderDate = orderDate;	}
	public String getStatus() {		return status;	}
	public void setStatus(String status) {		this.status = status;	}
	public int getTotalQuantity() {		return totalQuantity;	}
	public void setTotalQuantity(int totalQuantity) {		this.totalQuantity = totalQuantity;	}
	public UUID getUid() {		return uid;	}
	public void setUid(UUID uid) {		this.uid = uid;	}
    
}
