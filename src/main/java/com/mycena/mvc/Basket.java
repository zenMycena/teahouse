package com.mycena.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Basket  implements Serializable {

	private static final long serialVersionUID = -1779666204730031281L;
	
	//private ArrayList<MenuItemForm> items = new ArrayList<MenuItemForm>();
	private Map<UUID,MenuItemForm> items = new LinkedHashMap<UUID,MenuItemForm>();
	
	public Basket() {
		
	}

	public Basket(Map<UUID,MenuItemForm> items) {
		this.items = items;
	}

	
	public MenuItemForm add(MenuItemForm item) {
		UUID uuid = UUID.randomUUID();
		item.setId(uuid);
		System.out.println(uuid);
		items.put(item.getId(), item);
		return item;
	}

	
	public void delete(UUID key) {
		items.remove(key);
		//items.remove(o);
	}

	
	public MenuItemForm findById(String key) {
		
		return null;
	}

	
	public List<MenuItemForm> findAll() {
		return new ArrayList<MenuItemForm>(items.values());
	}
	
	public List<MenuItemForm> getItems() {
		return findAll();
	}
	
	public int getSize() {
		return items.size();
	}
	
	public int  getPrice(){
		
		Map<UUID, MenuItemForm> list = items;
		
		if (getSize() != 0) {
			int total = 0;
			for(Entry<UUID, MenuItemForm> entry : list.entrySet()) {
//			    String key = entry.getKey();
//			    HashMap value = entry.getValue();
			    total += entry.getValue().getPrice();
			}
			return total;
		}
		
		return 0;
	}
	
	public int  getQuantity(){

		Map<UUID, MenuItemForm> list = items;
		
		if (getSize() != 0) {
			int total = 0;
			for(Entry<UUID, MenuItemForm> entry : list.entrySet()) {
//			    String key = entry.getKey();
//			    HashMap value = entry.getValue();
			    total += entry.getValue().getQuantity();
			}
			return total;
		}
		
		return 0;
	}
	
	public void clear() {
		items = new HashMap<UUID,MenuItemForm>();
	}
	
}
