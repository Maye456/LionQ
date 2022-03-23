package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.IPostBusinessService;
import com.gcu.model.PostModel;
import com.gcu.model.SearchPostModel;

@Controller
@RequestMapping("/post")
public class PostController
{
	@Autowired
	IPostBusinessService postService;
	
	@GetMapping("/all")
	public String showAll(Model model)
	{
		List<PostModel> posts = postService.getPosts();
		model.addAttribute("title", "");
		model.addAttribute("searchModel", new SearchPostModel());
		model.addAttribute("posts", posts);
		return "posts";
	}
	
	@GetMapping("/addNewForm")
	public String displayAddNewForm(Model model)
	{
		model.addAttribute("title", "Create New Post");
		model.addAttribute("postModel", new PostModel());
		return "postAddNewForm";
	}
	
	// Process request from the AddPostForm. Add new post to the database. Show all posts
	@PostMapping("/addNew")
	public String addPost(@Valid PostModel newPost, BindingResult bindingResult, Model model)
	{
		// Add the new post
		postService.addOne(newPost);
		
		// Get updated list of all the posts
		List<PostModel> posts = postService.getPosts();
		
		// Display all posts
		model.addAttribute("posts", posts);
		model.addAttribute("searchModel", new SearchPostModel());
		return "posts";
	}
	
	@GetMapping("/searchForm")
	public String displaySearchForm(Model model)
	{
		// Display Search Form View
		model.addAttribute("title", "Search For Posts");
		model.addAttribute("searchPostModel", new SearchPostModel());
		return "postSearchForm";
	}
	
	@PostMapping("/searchResults")
	public String showAllPosts(@Valid SearchPostModel searchModel, BindingResult bindingResult, Model model)
	{
		System.out.println("Performing search results for " + searchModel.getSearchTerm());
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search For Posts");
			return "postSearchForm";
		}
		List<PostModel> posts = postService.searchPosts(searchModel.getSearchTerm());
		model.addAttribute("title", "Search For Posts");
		model.addAttribute("searchPostModel", searchModel);
		model.addAttribute("posts", posts);
		return "posts";
	}
	
	// Process request for the delete post
	@PostMapping("/deleteForm")
	public String deletePostForm(@Valid PostModel postModel, BindingResult bindingResult, Model model)
	{
		// Display new order form
		model.addAttribute("title", "Are You Sure You Want To Delete This Post?");
		model.addAttribute("postModel", postModel);
		return "postDelete";
	}
	
	@PostMapping("/doDelete") 
	public String deletePost(@Valid PostModel post, BindingResult bindingResult, Model model)
	{
		postService.deleteOne(post.getPost_id());
		
		List<PostModel> posts = postService.getPosts();
		
		model.addAttribute("posts", posts);
		return "posts";
	}
	
	@PostMapping("/editForm") 
	public String displayEditForm(PostModel postModel, Model model)
	{	
		// Display new order form
		model.addAttribute("title", "Edit Post");
		model.addAttribute("postModel", postModel);
		return "postEdit";
	}
	
	@PostMapping("/doUpdate") 
	public String updatePost(@Valid PostModel post, BindingResult bindingResult, Model model)
	{
		System.out.println("CONTROLLER POST ID:: " + post.getPost_id());
		
		// Update post
		postService.updateOne(post.getPost_id(), post);
		
		// get updated list of all the post
		List<PostModel> posts = postService.getPosts();
		
		// display all orders
		model.addAttribute("posts", posts); 
		model.addAttribute("searchModel", new SearchPostModel()); 
		return "posts";
	}
}
