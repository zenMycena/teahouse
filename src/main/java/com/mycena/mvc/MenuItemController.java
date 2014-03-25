package com.mycena.mvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycena.data.MenuItem;
import com.mycena.data.MenuItemRepository;
import com.mycena.data.User;
import com.mycena.mvc.utils.StringParser.ParserOperte;
import com.mycena.mvc.utils.StringParser.operate.BeverageTagParserOperate;
import com.mycena.security.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/")
public class MenuItemController {
    private MenuItemRepository menuItemRepository;
    @Autowired
    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
    @Autowired
	private Basket basket;
    
    ParserOperte beveragTagParserOperte = new BeverageTagParserOperate();
    
    /**************     CREATE      ***************/
    @RequestMapping(value="menu/create",method=RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm,String id) {
    	return new ModelAndView("menuitems/menulistCreate");	
    }
    
    @RequestMapping(value="menu/create",method=RequestMethod.POST)
    public String addMenuItem(@ModelAttribute(value="menuItemForm")MenuItemForm menuItemForm ) throws UnsupportedEncodingException {
    	  MenuItem menuItem = new MenuItem();
    	  menuItem.setName(menuItemForm.getName());
    	  System.out.println(menuItem.getName());
    	  menuItem.setHotPrice(menuItemForm.getHotPrice());
    	  menuItem.setIcePrice(menuItemForm.getIcePrice());
    	  menuItem.setTag(beveragTagParserOperte.webStringParser(menuItemForm.getTag()));
     	  menuItem.setCdate(new Date());
    	  menuItem.setRecommend(menuItemForm.getRecommend());
//    	  menuItem.setOriginal(menuItemForm.getOriginal());
//    	  menuItem.setMinToPrepare(menuItemForm.getMinToPrepare());
    	  menuItemRepository.save(menuItem);
    	  return "redirect:/";
    }
    
    /**************     READ      ***************/
    @RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView getList(@ModelAttribute(value="menuItemForm") MenuItemForm menuItem, @CurrentUser User currentUser) {
    	
    	
    	ArrayList<MenuItem> al = new ArrayList<>();
        long maxOrder;
    	if (al.size() == 0) {
    		Iterable<MenuItem> menuitems = menuItemRepository.findAll();
    		for (MenuItem menuitem : menuitems) {
				al.add(menuitem);
			}
    		
    		if (currentUser!=null && currentUser.getRole().equalsIgnoreCase("ADMIN")) {
    			return new ModelAndView("menuitems/menulistAdmin", "menuitems", menuitems);
			}
    		return new ModelAndView("menuitems/menulistUser", "menuitems", menuitems);
		}else {
			maxOrder = al.get(al.size()-1).getId();
			List<MenuItem> menuitems = menuItemRepository.findWithMaxOrder(maxOrder);
			al.addAll(menuitems);
			
			if (currentUser!=null && currentUser.getRole().equalsIgnoreCase("ADMIN")) {
				return new ModelAndView("menuitems/menulistAdmin", "menuitems", al);
			}

			return new ModelAndView("menuitems/menulistUser", "menuitems", al);
		}
    	
    }
    
    /**************     UPDATE      ***************/
    @RequestMapping(value="menu/update/{id}",method=RequestMethod.GET)
    public ModelAndView updatePage(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm, @PathVariable String id) {
    	MenuItem menuItem = menuItemRepository.findOne(Long.parseLong(id));
		return new ModelAndView("menuitems/menulistUpdate", "menuItems", menuItem);
    }
    
    @RequestMapping(value="menu/update",method=RequestMethod.POST)
    public ModelAndView updateMenuItem(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm ) throws UnsupportedEncodingException {
    	  MenuItem menuItem = menuItemRepository.findOne(menuItemForm.getId());
    	  menuItem.setName(menuItemForm.getName());
    	  menuItem.setHotPrice(menuItemForm.getHotPrice());
    	  menuItem.setIcePrice(menuItemForm.getIcePrice());
    	  menuItem.setTag(menuItemForm.getTag());
    	  menuItem.setCdate(new Date());
    	  menuItem.setRecommend(menuItemForm.getRecommend());
    	  menuItem.setOriginal(menuItemForm.getOriginal());
    	  menuItem.setMinToPrepare(menuItemForm.getMinToPrepare());
    	  menuItemRepository.save(menuItem);
    	  return new ModelAndView("menuitems/menulistUpdate", "menuItems", menuItem);
    }
    
    /**************     DELETE      ***************/
    @RequestMapping(value="menu/delete/{id}",method=RequestMethod.GET)
    public ModelAndView deletePage(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm,@PathVariable String id) {
    	MenuItem menuItem = menuItemRepository.findOne(Long.parseLong(id));
		return new ModelAndView("menuitems/menulistDelete", "menuItems", menuItem);
    }
    
    @RequestMapping(value="menu/delete",method=RequestMethod.POST)
    public String deleteMenuItem(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm ) {
    	 MenuItem menuItem = menuItemRepository.findOne(menuItemForm.getId());
    	 menuItemRepository.delete(menuItem);
    	 return "redirect:/";
    }
    
    @ModelAttribute("basket")
	private Basket getBasket() {
		return basket;
	}
}
