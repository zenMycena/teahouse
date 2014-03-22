package com.mycena.mvc;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;


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
    private int status;
    private UUID uid;
    private String ice;
    private String sweetness;
    private int quantity;
    private int totalQuantity;
    
    private String tag;//
    private int recommend;//
    private int original; //
    
	public double getPrice() {		return price;	}
	public void setPrice(double price) {		this.price = price;	}
	public int getQuantity() {		return quantity;	}
	public void setQuantity(int quantity) {		this.quantity = quantity;	}

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
	public int getStatus() {		return status;	}
	public void setStatus(int status) {		this.status = status;	}
	public int getTotalQuantity() {		return totalQuantity;	}
	public void setTotalQuantity(int totalQuantity) {		this.totalQuantity = totalQuantity;	}
	public UUID getUid() {		return uid;	}
	public void setUid(UUID uid) {		this.uid = uid;	}
    
}
