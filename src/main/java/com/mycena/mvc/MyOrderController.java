package com.mycena.mvc;


import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycena.data.OrderList;
import com.mycena.data.OrderListRepository;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {
	@Autowired
	OrderListRepository orderListRepository;
	@RequestMapping(method = RequestMethod.GET)
	public String myOrderPage() {
		return "myOrder";
	}
	
	@RequestMapping(value="status/{id}/{time}", method = RequestMethod.POST)
	public @ResponseBody OrderList changeStatusByUid(@PathVariable long id, @PathVariable long time) {
		OrderList oList = orderListRepository.findOne(id);
		oList.setStatus(2);
		oList.setFinishDate(new Date(time));
		orderListRepository.save(oList);
		return oList;
	}
	
	@RequestMapping(value="finalstatus/{id}", method = RequestMethod.POST)
	public @ResponseBody OrderList changeFinalStatusByUid(@PathVariable long id) {
		OrderList oList = orderListRepository.findOne(id);
		oList.setStatus(3);
		orderListRepository.save(oList);
		return oList;
	}
}
