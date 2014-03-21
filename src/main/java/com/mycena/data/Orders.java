package com.mycena.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String beverageName;
	private String ice;
	private String sweetness;
	private int quantity;
	private UUID uid;
/*	@ManyToOne
	@JoinColumn(name="orderList")
	private OrderList orderList;*/
	public long getId() {		return id;	}
	public void setId(long id) {		this.id = id;	}
	public String getBeverageName() {		return beverageName;	}
	public void setBeverageName(String beverageName) {		this.beverageName = beverageName;	}
	public String getIce() {		return ice;	}
	public void setIce(String ice) {		this.ice = ice;	}
	public String getSweetness() {		return sweetness;	}
	public void setSweetness(String sweetness) {		this.sweetness = sweetness;	}
	public int getQuantity() {		return quantity;	}
	public void setQuantity(int quantity) {		this.quantity = quantity;	}
	public UUID getUid() {		return uid;	}
	public void setUid(UUID uid) {		this.uid = uid;	}

	
	
	
	
	
}
