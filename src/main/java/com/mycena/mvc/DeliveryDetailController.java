package com.mycena.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycena.data.User;

@Controller
@RequestMapping("/deliveryDetail")
public class DeliveryDetailController {
	@Autowired
	private Basket basket;
	private User user;
	
	@RequestMapping(method = RequestMethod.GET)
	public String myOrderPage() {
		return "menuitems/deliveryDetail";
	}
	
	@ModelAttribute("basket")
	private Basket getBasket() {
		return basket;
	}
	
	@ModelAttribute("user")
	private User getUser() {
		return user;
	}
}
