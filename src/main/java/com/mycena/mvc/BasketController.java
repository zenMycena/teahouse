package com.mycena.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycena.data.MenuItemRepository;
import com.mycena.data.OrderListRepository;
import com.mycena.data.OrderRepository;
import com.mycena.mvc.utils.StringParser.ParserOperte;
import com.mycena.mvc.utils.StringParser.operate.IceValueParserOperate;
import com.mycena.mvc.utils.StringParser.operate.SugerValueParserOperate;



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
	
	ParserOperte IceValueParserOperate = new IceValueParserOperate();
	ParserOperte SugerValueParserOperate = new SugerValueParserOperate();

	@RequestMapping(value = "/removeFromBasket" , method = RequestMethod.POST)
	
	public String remove(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Remove {} from the basket", menuItem.getId());
		System.out.println(menuItem.getUid());
		basket.delete(menuItem.getUid());
		return "redirect:/showBasket";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String add(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem) {
		//LOG.debug("Add {} from the basket", menuItem.getId());
		menuItem.setPrice(countPrice(menuItem));
		menuItem.setIce(IceValueParserOperate.webStringParser(menuItem.getIce()));
		menuItem.setQuantity(menuItem.getQuantity());
		menuItem.setSweetness(SugerValueParserOperate.webStringParser(menuItem.getSweetness()));
		menuItem.setMinToPrepare(menuItemRepository.findByName(menuItem.getName()).getMinToPrepare()*menuItem.getQuantity());
		basket.add(menuItem);
		System.out.println(basket.getItems().get(0).getUid());
		
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
