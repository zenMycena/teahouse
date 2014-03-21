package com.mycena.mvc;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycena.data.OrderList;
import com.mycena.data.OrderListRepository;
import com.mycena.data.OrderRepository;
import com.mycena.data.Orders;

@Controller
public class RestOrderListController {
		
	private OrderRepository orderRepository;
	private OrderListRepository orderListRepository;
    @Autowired
    public RestOrderListController(OrderListRepository orderListRepository, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
    }
    @Autowired
   	private Basket basket;
    
    @RequestMapping("/adddata")
    public @ResponseBody Iterable<OrderList> adddata() {
    	OrderList ol = new OrderList();
    	ol.setUsername("tim");
    	ol.setOrderDate(new Date());
    	UUID uid = new UUID(new Date().getTime(), new Date().getTime()+999);
    	Orders order1 = new Orders();
    	Orders order2 = new Orders();
    	ol.setUid(uid);
    	ol.setPhone("0987654321");
    	ol.setAddress("asdasdasdsd");
    	order1.setBeverageName("aa");
    	order1.setUid(uid);
    	order2.setBeverageName("aac");
    	order2.setUid(uid);
    	orderListRepository.save(ol);
    	orderRepository.save(order1);
    	orderRepository.save(order2);
    	return orderListRepository.findUncompleteOrders();
    }
    /**************************        Add fake data         *********************************/
    
    
    /**************************        User rest         *********************************/
    @RequestMapping("/getuserorder/{username}/{id}")
    public @ResponseBody List<OrderList> getUserOrder(@PathVariable String username, @PathVariable long id) {
    	return orderListRepository.findUserOrder(username, id);
    }    
    
    /**************************        Admin rest         *********************************/
    @RequestMapping("/getallorderlist")
    public @ResponseBody Iterable<OrderList> getorderlist() {
    	return orderListRepository.findUncompleteOrders();
    }
    
    @RequestMapping("/getneworderlist/{id}")
    public @ResponseBody Iterable<OrderList> getneworderlist(@PathVariable long id) {
    	return orderListRepository.findNewOrders(id);
    }
    
    @RequestMapping("/gettopid")
    public @ResponseBody OrderList gettopid() {
    	return orderListRepository.findTopid().get(0);
    }
    
    @RequestMapping("/getorders/{uid}")
    public @ResponseBody List<Orders> getorders(@PathVariable UUID uid) {
    	
        return orderRepository.findByUid(uid);
    }
  
    
    @RequestMapping("/finishorders")
    public @ResponseBody List<OrderList> finishorders() {
    	
        return orderListRepository.findByStatus();
        	
    }

    
    
}
