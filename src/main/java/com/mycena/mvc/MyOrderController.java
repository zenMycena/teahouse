package com.mycena.mvc;

import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycena.data.OrderList;
import com.mycena.data.OrderListRepository;
import com.mycena.data.OrderRepository;
import com.mycena.data.Orders;

@Controller
@RequestMapping("/myOrder")
public class MyOrderController {

	
	@Autowired
	private Basket basket;
	@Autowired
	private UserInfo userInfo;
	@Autowired
	OrderListRepository orderListRepository;
	@Autowired
	OrderRepository orderRepository;
	@RequestMapping(method = RequestMethod.GET)
	public String myOrderPage() {
		return "menuitems/myOrder";
	}
	
	@ModelAttribute("basket")
	private Basket getBasket() {
		return basket;
	}
	
	@ModelAttribute("userInfo")
	private UserInfo getUser() {
		return userInfo;
	}
	
	@RequestMapping(value="/takeorder", method = RequestMethod.POST)
	public String takeOrder(@ModelAttribute(value="userInfo") UserInfo userInfo) {
		UUID uid = new UUID(new Date().getTime(), new Date().getTime()+999);
		OrderList orderList = new OrderList();
		orderList.setOrderDate(new Date());
		orderList.setTotalPrice(basket.getPrice());
		orderList.setStatus("未確認");
		orderList.setUsername(userInfo.getName());
		orderList.setUid(uid);
		orderList.setPhone(userInfo.getPhone());
		orderList.setAddress(userInfo.getAddress());
		orderList.setPrepareTime(basket.getTotaltime());
		orderListRepository.save(orderList);
		Iterator<MenuItemForm> list = basket.getItems().iterator();
		while (list.hasNext()) {
			Orders orders = new Orders();
			MenuItemForm menuItemForm = list.next();
			orders.setBeverageName(menuItemForm.getName());
			orders.setIce(menuItemForm.getIce());
			orders.setQuantity(menuItemForm.getQuantity());
			orders.setSweetness(menuItemForm.getSweetness());
			orders.setUid(uid); 
			
			orderRepository.save(orders);
		} 
		
		basket.clear();
		return "redirect:/";
	}
	
	@RequestMapping(value="status/{id}/{time}", method = RequestMethod.POST)
	public @ResponseBody OrderList changeStatusByUid(@PathVariable long id, @PathVariable long time) {
		OrderList oList = orderListRepository.findOne(id);
		oList.setStatus("準備中");
		oList.setFinishDate(new Date(time));
		orderListRepository.save(oList);
		return oList;
	}
	
	@RequestMapping(value="finalstatus/{id}", method = RequestMethod.POST)
	public @ResponseBody OrderList changeFinalStatusByUid(@PathVariable long id) {
		OrderList oList = orderListRepository.findOne(id);
		oList.setStatus("完成");
		orderListRepository.save(oList);
		return oList;
	}
}
