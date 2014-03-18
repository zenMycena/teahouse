package com.mycena.mvc;

import java.util.ArrayList;
import java.util.List;

import com.mycena.data.MenuItem;
import com.mycena.data.MenuItemRepository;
import com.mycena.data.Message;
import com.mycena.data.MessageRepository;
import com.mycena.data.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MenuItemController {
    private MenuItemRepository menuItemRepository;
    @Autowired
    public MenuItemController(MenuItemRepository menuItemRepository) {

        this.menuItemRepository = menuItemRepository;
    }
    
    /**************     CREATE      ***************/
    @RequestMapping(value="menu/create",method=RequestMethod.GET)
    public ModelAndView addPage() {
    	
			return new ModelAndView("menuitems/menulistCreate");
		
    	
    }
    
    /**************     READ      ***************/
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getList() {
    	ArrayList<MenuItem> al = new ArrayList<>();
        long maxOrder;
    	if (al.size() == 0) {
    		Iterable<MenuItem> menuitems = menuItemRepository.findAll();
    		for (MenuItem menuitem : menuitems) {
				al.add(menuitem);
			}
    		return new ModelAndView("menuitems/menulist", "menuitems", menuitems);
		}else {
			maxOrder = al.get(al.size()-1).getId();
			List<MenuItem> menuitems = menuItemRepository.findWithMaxOrder(maxOrder);
			al.addAll(menuitems);
			return new ModelAndView("menuitems/menulist", "menuitems", al);
		}
    	
    }
    /**************     UPDATE      ***************/
    /**************     DELETE      ***************/
}
