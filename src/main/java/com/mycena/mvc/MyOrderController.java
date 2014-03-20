package com.mycena.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {
	
	@Autowired
	private Basket basket;
	
	@RequestMapping(method = RequestMethod.GET)
	public String myOrderPage() {
		return "menuitems/myOrder";
	}
	
	@ModelAttribute("basket")
	private Basket getBasket() {
		return basket;
	}
}
