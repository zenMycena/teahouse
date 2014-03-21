package com.mycena.mvc;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import com.gemstone.gemfire.internal.cache.FilterProfile.interestType;


public class MenuItemForm {
	//@NotEmpty(message = "name is required.")
    private UUID id;
	
	//@NotEmpty(message = "name is required.")
    private String name;

    //@NotEmpty(message = "account is required.")
    private double hotPrice;
    
    //@NotEmpty(message = "account is required.")
    private double icePrice;
    
    //@NotEmpty(message = "account is required.")
    private String tag;
    
    //@NotEmpty(message = "account is required.")
    private int recommend;
    
    //@NotEmpty(message = "account is required.")
    private int original;
    
    //@NotEmpty(message = "account is required.")
    private int minToPrepare;
    
    private int ice;
    
    private int sweetness;
    
    private int quantity;
    
    private double price;
    
    
	public double getPrice() {		return price;	}
	public void setPrice(double price) {		this.price = price;	}
	public int getQuantity() {		return quantity;	}
	public void setQuantity(int quantity) {		this.quantity = quantity;	}
	public int getSweetness() {		return sweetness;	}
	public void setSweetness(int sweetness) {		this.sweetness = sweetness;	}
	public int getIce() {		return ice;	}	
	public void setIce(int ice) {		this.ice = ice;	}
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
       
}
