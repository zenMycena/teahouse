package com.mycena.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String myOrderPage() {
		return "myOrder";
	}
}
