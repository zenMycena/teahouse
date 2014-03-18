package com.mycena.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@RequestMapping("/**")
    public String notFound() {
        return "redirect:/?";
    }
}
