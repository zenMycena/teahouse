package com.mycena.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String myOrderPage() {
		return "admin/orders";
	}
	
	@RequestMapping(value="/orderdetail", method = RequestMethod.GET)
	public String myDetailPage() {
		return "admin/orderdetail";
	}
}