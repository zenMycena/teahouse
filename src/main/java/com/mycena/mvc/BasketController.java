package com.mycena.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gemstone.gemfire.internal.cache.FilterProfile.interestType;


@Controller
@RequestMapping(value = "/basket")
public class BasketController {
	@Autowired
	private Basket basket;
	@RequestMapping(value = "/removeFromBasket" , method = RequestMethod.POST)
	
	public String remove(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Remove {} from the basket", menuItem.getId());
		basket.delete(menuItem.getId());
		return "redirect:/showBasket";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String add(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Add {} from the basket", menuItem.getId());
		menuItem.setPrice(countPrice(menuItem));
		basket.add(menuItem);
		return "redirect:/";
	}
			
	private double countPrice(MenuItemForm m){
		
			if(m.getIce()<3){
				return m.getIcePrice()*m.getQuantity();
			}else{
				return m.getHotPrice()*m.getQuantity();
			}	

		
	}
	
	@ModelAttribute("basket")
	private Basket getBasket() {
		return basket;
	}
}
