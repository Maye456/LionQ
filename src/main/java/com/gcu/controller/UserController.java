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
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	IUserBusinessService service;
	
	private UserDataServiceForRepository userService;
	
	@Autowired
	public UserController(UserDataServiceForRepository userService)
	{
		this.userService = userService;
	}
	
	// Admin Page for all Users
	@GetMapping("/admin") 
	public String showUsersForAdmin(Model model)
	{  
		List<UserModel> users = service.getUsers();
        model.addAttribute("title", "Admin Page");
        model.addAttribute("searchModel", new SearchUserModel());
        model.addAttribute("users", users);
        return "userAdmin";
	}
	
	@GetMapping("/searchUserForm")
	public String displaySearchForm(Model model)
	{
		// Display Search Form View
		model.addAttribute("title", "Search For Users");
		model.addAttribute("searchUserModel", new SearchUserModel());
		return "userSearchForm";
	}
	
	@PostMapping("/searchResults")
	public String showAllUsers(@Valid SearchUserModel searchModel, BindingResult bindingResult, Model model)
	{
		System.out.println("Performing search results for " + searchModel.getSearchTerm2());
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search For Users");
			return "userSearchForm";
		}
		List<UserModel> users = service.searchUsers(searchModel.getSearchTerm2());
		model.addAttribute("title", "Search For Users");
		model.addAttribute("searchPostModel", searchModel);
		model.addAttribute("users", users);
		return "users";
	}
	
	// Process request for the delete post
	@PostMapping("/delete")
	public String deleteUser(@Valid UserModel user, BindingResult bindingResult, Model model)
	{
		service.deleteOne(user.getId());
		
		List<UserModel> users = service.getUsers();
			
		model.addAttribute("users", users);
		model.addAttribute("searchModel", new SearchUserModel());
		return "userAdmin";
	}
}