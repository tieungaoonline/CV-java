package com.windblade.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class MainController {
 
	  @RequestMapping(value = "/{locale:en|vi}/*")
	    public String login2(Model model) {
	        return "index";
	    }

	  @RequestMapping(value = "/*")
	    public String login(Model model) {
	        return "index";
	    }
	
}