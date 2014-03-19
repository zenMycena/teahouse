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
    @RequestMapping("/getorderlist")
    public @ResponseBody Iterable<OrderList> getorderlist() {
    	OrderList ol = new OrderList();
    	ol.setUsername("tim");
    	ol.setOrderDate(new Date());
    	UUID uid = new UUID(new Date().getTime(), new Date().getTime()+999);
    	Orders order1 = new Orders();
    	Orders order2 = new Orders();
    	ol.setUid(uid);
    	
    	order1.setBeverageName("aa");
    	order1.setUid(uid);
    	order2.setBeverageName("aac");
    	order2.setUid(uid);
    	orderListRepository.save(ol);
    	orderRepository.save(order1);
    	orderRepository.save(order2);
    	return orderListRepository.findAll();
    }
    
    @RequestMapping("/getorders/{uid}")
    public @ResponseBody List<Orders> getorders(@PathVariable UUID uid) {
    	
        return orderRepository.findByUid(uid);
    }
  
    
    @RequestMapping("/finishorders")
    public @ResponseBody List<OrderList> finishorders() {
    	
        return orderListRepository.findByStatus(0);
        	
    }
    
    @RequestMapping("/checkorder")
    public @ResponseBody boolean checkorder() {
    	if (true) {
    		 return true;
		}else {
			 return false;
		}
       
        	
    }
    
}
