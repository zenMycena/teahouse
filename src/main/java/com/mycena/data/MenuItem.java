package com.mycena.data;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MenuItem {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	//@NotEmpty(message = "Name is required.")
    private String name;
	//@NotEmpty(message = "Hot Price is required.")
    private double hotPrice;
	//@NotEmpty(message = "Ice Price is required.")
    private double icePrice;
	//@NotEmpty(message = "Tag is required.")
    private String tag;
	//@NotEmpty(message = "Date is required.")
    private Date cdate;
	//@NotEmpty(message = "Recommend is required.")
    private int recommend;
	//@NotEmpty(message = "Original is required.")
    private int original;
	//@NotEmpty(message = "Minute To Prepare is required.")
    private int minToPrepare;
	
	public Long getId() {		return id;	}
	public void setId(Long id) {		this.id = id;	}
	public String getName() {		return name;	 }
	public void setName(String name) throws UnsupportedEncodingException {		this.name = new String(name.getBytes(),"UTF-8");	}
	public double getHotPrice() {		return hotPrice;	}
	public void setHotPrice(double hotPrice) {		this.hotPrice = hotPrice;	}
	public double getIcePrice() {		return icePrice;	}
	public void setIcePrice(double icePrice) {		this.icePrice = icePrice;	}
	public String getTag() {		return tag;	}
	public void setTag(String tag) throws UnsupportedEncodingException {		this.tag = new String(tag.getBytes(),"UTF-8");	}
	public Date getCdate() {		return cdate;	 }
	public void setCdate(Date cdate) {		this.cdate = cdate;	}
	public int getRecommend() {	return recommend;	}
	public void setRecommend(int recommend) {		this.recommend = recommend;	}
	public int getOriginal() {		return original;	}
	public void setOriginal(int original) {		this.original = original;	}
	public int getMinToPrepare() {		return minToPrepare;	}
	public void setMinToPrepare(int minToPrepare) {		this.minToPrepare = minToPrepare;	}	
	
}
