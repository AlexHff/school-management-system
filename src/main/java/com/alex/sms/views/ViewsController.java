package com.alex.sms.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ViewsController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("*")
	public String error404() {
		return "error/404";
	}
}
