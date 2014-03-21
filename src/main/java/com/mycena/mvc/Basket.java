package com.mycena.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Basket  implements Serializable {

	private static final long serialVersionUID = -1779666204730031281L;
	
	private ArrayList<MenuItemForm> items = new ArrayList<MenuItemForm>();

	
	public Basket() {
		
	}

	public Basket(ArrayList<MenuItemForm> items) {
		this.items = items;
	}

	
	public MenuItemForm add(MenuItemForm item) {
		items.add(item);
		return item;
	}

	
	public void delete(long key) {
		items.remove(key);
	}

	
	public MenuItemForm findById(String key) {
		
		return null;
	}

	
	public List<MenuItemForm> findAll() {
		return items;
	}
	
	public List<MenuItemForm> getItems() {
		return findAll();
	}
	
	public int getSize() {
		return items.size();
	}
	
	public int  getPrice(){
		List<MenuItemForm> list = findAll();
		if (getSize() !=0) {
			double total = 0;
			for (int i = 0; i < getSize(); i++) {
				total=list.get(i).getPrice()+total;
			}
			
		return (int)total;
		}
		
		return 0;
	}
	
	public int  getQuantity(){
		List<MenuItemForm> list = findAll();
		if (getSize() !=0) {
			double total = 0;
			for (int i = 0; i < getSize(); i++) {
				total=list.get(i).getQuantity()+total;
			}
			
		return (int)total;
		}
		
		return 0;
	}
	
	public void clear() {
		items = new ArrayList<MenuItemForm>();
	}
	
}
