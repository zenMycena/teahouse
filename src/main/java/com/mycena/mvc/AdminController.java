package com.mycena.mvc;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycena.data.MenuItem;
import com.mycena.data.User;
import com.mycena.security.CurrentUser;

@Controller
@RequestMapping()
public class AdminController {
	
	
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String myOrderPage(@CurrentUser User currentUser) {
		if (currentUser!=null && currentUser.getRole().equalsIgnoreCase("ADMIN")) {
			return "admin/orders";
		}
		return "/";
	}
	
//	/**************     CREATE      ***************/
//    @RequestMapping(value="menu/create",method=RequestMethod.GET)
//    public ModelAndView addPage(@ModelAttribute(value="menuItemForm") MenuItemForm menuItemForm,String id) {
//    	return new ModelAndView("menuitems/menulistCreate");	
//    }
//    
//    @RequestMapping(value="menu/create",method=RequestMethod.POST)
//    public String addMenuItem(@ModelAttribute(value="menuItemForm")MenuItemForm menuItemForm ) throws UnsupportedEncodingException {
//    	  MenuItem menuItem = new MenuItem();
//    	  menuItem.setName(menuItemForm.getName());
//    	  menuItem.setHotPrice(menuItemForm.getHotPrice());
//    	  menuItem.setIcePrice(menuItemForm.getIcePrice());
//    	  menuItem.setTag(menuItemForm.getTag());
//    	  menuItem.setCdate(new Date());
//    	  menuItem.setRecommend(menuItemForm.getRecommend());
//    	  menuItem.setOriginal(menuItemForm.getOriginal());
//    	  menuItem.setMinToPrepare(menuItemForm.getMinToPrepare());
//    	  menuItemRepository.save(menuItem);
//    	  return "redirect:/";
//    }
}
