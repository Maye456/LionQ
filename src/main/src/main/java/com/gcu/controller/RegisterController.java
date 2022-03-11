/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Displays register page and processes the user's registration
 */

package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.IUserBusinessService;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.PostModel;
import com.gcu.model.SearchPostModel;
import com.gcu.model.SearchUserModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@Autowired
	IUserBusinessService service;
	
	private UserDataServiceForRepository userService;
	
	@Autowired
	public RegisterController(UserDataServiceForRepository userService)
	{
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display Register View
		model.addAttribute("title", "Register Form");
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel newUser, BindingResult bindingResult, Model model)
	{
		// Check if the user exists
		if(userService.userExists(newUser.getEmail()))
		{
			bindingResult.addError(new FieldError("newUser", "email", "Email already in use"));
		}
		
		// Check if the passwords match
		if(newUser.getPassword() != null && newUser.getRpassword() != null)
			if(!newUser.getPassword().equals(newUser.getRpassword()))
			{
				bindingResult.addError(new FieldError("newUser", "rpassword", "Passwords must match"));
			}
		
		if (bindingResult.hasErrors())
		{
			return "register";
		}
		
		// add the new user
        service.createUser(newUser);
		
		model.addAttribute("userModel", newUser);
		return "registerSuccess";
	}
}
