package com.mycena.mvc;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycena.data.MenuItemRepository;
import com.mycena.data.OrderList;
import com.mycena.data.OrderListRepository;
import com.mycena.data.OrderRepository;
import com.mycena.data.Orders;
import com.mycena.mvc.utils.ParseCondimentToString;



@Controller
@RequestMapping(value = "/basket")
public class BasketController {
	@Autowired
	private Basket basket;
	@Autowired
	private OrderListRepository orderListRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private MenuItemRepository menuItemRepository;

	@RequestMapping(value = "/removeFromBasket" , method = RequestMethod.POST)
	
	public String remove(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Remove {} from the basket", menuItem.getId());
		basket.delete(menuItem.getId());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String add(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Add {} from the basket", menuItem.getId());
		//System.out.println(menuItem.getId());
		menuItem.setPrice(countPrice(menuItem));
		menuItem.setIce(ParseCondimentToString.iceToString(menuItem.getIce()));
		menuItem.setQuantity(menuItem.getQuantity());
		menuItem.setSweetness(ParseCondimentToString.sweetnessToString(menuItem.getSweetness()));
		menuItem.setMinToPrepare(menuItemRepository.findByName(menuItem.getName()).getMinToPrepare()*menuItem.getQuantity());
		basket.add(menuItem);
		//System.out.println(menuItem.getName());
		
		return "redirect:/";
	}
	
			
	private double countPrice(MenuItemForm m){
		
			if(Integer.parseInt(m.getIce())<3){
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
