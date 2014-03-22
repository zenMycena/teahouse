package com.mycena.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycena.data.User;
import com.mycena.data.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**************     CREATE      ***************/
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public ModelAndView addUser(@ModelAttribute(value="userForm")UserForm userForm , String id) {
    		Iterable<User> user = userRepository.findAll();
    		return new ModelAndView("users/userCreate", "users", user);
    }
    
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public String addUser(@ModelAttribute(value="userForm")UserForm userForm ) {
    	  User user = new User();
    	  user.setAccount(userForm.getAccount());
    	  user.setName(userForm.getName());
    	  user.setPassword(userForm.getPassword());
    	  user.setPhone(userForm.getPhone());
    	  user.setEmail(userForm.getEmail());
    	  user.setAddress(userForm.getAddress());
    	  userRepository.save(user);
    	  return "redirect:/login";
    }
    
    /**************     READ      ***************/
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ModelAndView getUser(@PathVariable String id) {
    		User user = userRepository.findOne(Long.parseLong(id));
    		return new ModelAndView("users/user", "users", user);
    }
    
    /**************     UPDATE      ***************/
    @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
    public ModelAndView editUser(@ModelAttribute(value="userForm")UserForm userForm,@PathVariable String id) {
    		User user = userRepository.findOne(Long.parseLong(id));
			return new ModelAndView("users/userUpdate", "users", user);
    }
    
    @RequestMapping(value="/edit/",method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute(value="userForm")UserForm userForm ) {
    	User user = userRepository.findByAccount(userForm.getAccount());
    	user.setName(userForm.getName());
    	user.setPassword(userForm.getPassword());
    	user.setPhone(userForm.getPhone());
    	user.setEmail(userForm.getEmail());
    	user.setAddress(userForm.getAddress());
    	userRepository.save(user);
		return new ModelAndView("users/userUpdate", "users", user);
    }
    
    /**************     DELETE      ***************/
    /*@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable String id) {
    		//To do delete user method
			return null;
    }*/
}
