package com.mycena.mvc;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycena.data.MenuItem;
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
	int n = 0;
	@RequestMapping(value="/{account}",method = RequestMethod.GET)
	public ModelAndView myOrderPage(@PathVariable String account) {
		List<OrderList> orderLists = orderListRepository.findByAccount(account);
		MenuItemForm menuItemForm = new MenuItemForm();
		if(orderLists.size() !=0){
			OrderList newestOrder = orderLists.get(orderLists.size()-1);
			List<Orders> orders = orderRepository.findByUid(newestOrder.getUid());
			OrderList orderList = orderListRepository.findByUid(newestOrder.getUid());
			menuItemForm = new MenuItemForm();
			menuItemForm.setUid(newestOrder.getUid());
			menuItemForm.setFinishDate(orderList.getFinishDate());
			menuItemForm.setUsername(orderList.getUsername());
			menuItemForm.setPhone(orderList.getPhone());
			menuItemForm.setAddress(orderList.getAddress());
			menuItemForm.setEmail(orderList.getEmail());
			menuItemForm.setOrders(orders);
			menuItemForm.setPrice(newestOrder.getTotalPrice());
			menuItemForm.setTotalQuantity(count(orders));
			menuItemForm.setFinishDate(orderList.getFinishDate());
			menuItemForm.setStatus(orderList.getStatus());
			menuItemForm.setAccount(orderList.getAccount());
			return new ModelAndView("menuitems/myOrder", "menuItemForm", menuItemForm);
		}
		return new ModelAndView("menuitems/myOrder", "menuItemForm", menuItemForm);
	}
	
	public int count(List<Orders> list){
		Iterator<Orders> i = list.iterator();
		while (i.hasNext()) {
			n=i.next().getQuantity()+n;
		} 		
		return n;
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
		orderList.setAccount("user");
		orderList.setEmail(userInfo.getEmail());
		orderList.setPhone(userInfo.getPhone());
		orderList.setAddress(userInfo.getAddress());
		orderList.setPrepareTime(basket.getTotaltime());
		orderListRepository.save(orderList);
		Iterator<MenuItemForm> list = basket.getItems().iterator();
		while (list.hasNext()) {
			Orders orders = new Orders();
			MenuItemForm menuItemForm = list.next();
			orders.setPrice(countPrice(menuItemForm));
			orders.setBeverageName(menuItemForm.getName());
			orders.setIce(menuItemForm.getIce());
			orders.setQuantity(menuItemForm.getQuantity());
			orders.setSweetness(menuItemForm.getSweetness());
			orders.setUid(uid); 
			
			orderRepository.save(orders);
		} 
		
		basket.clear();
		return "redirect:/myOrder/user";
	}
	
	private double countPrice(MenuItemForm m){
		
		if(m.getIce() != "熱"){
			return m.getIcePrice()*m.getQuantity();
		}else{
			return m.getHotPrice()*m.getQuantity();
		}	
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
