package com.mycena.mvc;


public class MenuItemForm {
	//@NotEmpty(message = "name is required.")
    private long id;
	
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

	public long getId() {		return id;	}
	public void setId(long id) {		this.id = id;	}
	public String getName() {	return name;	}
	public void setName(String name) {		this.name = name;	}
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
