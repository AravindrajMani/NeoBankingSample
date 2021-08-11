package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signup() {

		return "signup.jsp";
	}

	@RequestMapping("/index")
	public String dashboard() {
		
		return "index.jsp";
	}
	
}
