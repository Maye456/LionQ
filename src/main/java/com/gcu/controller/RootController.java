package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController 
{
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/chat")
    public String chatapp()
    {
    	return "chat-app";
    }
	
	@GetMapping("/index2")
    public String index2()
    {
    	return "index2";
    }
}