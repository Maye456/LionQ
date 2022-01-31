package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.business.IUserBusinessService;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
//	@Autowired
//	IUserBusinessService service;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display Login View
		model.addAttribute("title", "Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
//	@PostMapping("/doLogin")
//	public String doLogin(@Valid UserModel login, BindingResult bindingResult, Model model)
//	{
//		// Check for validation errors
//		if (bindingResult.hasErrors())
//		{
//			model.addAttribute("title", "Login Form");
//			return "login";
//		}
//		
//		// Check for valid login
//		if (service.isAuthenticated(login));
//		{
//			// Login Success. Send them to the succes page to show what they entered
//			model.addAttribute("loginModel", login);
//			return "loginSuccess";
//		}
//		else
//		{
//			// Login Failed
//			return "login";
//		}
//	}
}
