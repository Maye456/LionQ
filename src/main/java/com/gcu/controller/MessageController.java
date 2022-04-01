package com.gcu.controller;

import com.gcu.business.UserBusinessService;
import com.gcu.data.MessageService;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.Message;
import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private UserDataServiceForRepository userService;

    @Autowired
    private MessageService messageService;

    @Autowired
	UserBusinessService service2;
    
    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, Model model) 
    {
    	// UserModel user = service2.getCurrentUser();
    	
        String userName = (String)request.getSession().getAttribute("username");
        Long userId = (Long)request.getSession().getAttribute("user_Id");
    	
//    	String userName = user.getUsername();
//        Long userId = user.getId();

        if (userName == null || userName.isEmpty() || userId == null) 
        {
            return "redirect:/chat/chatLogin";
        }

        model.addAttribute("username", userName);
        model.addAttribute("user_Id", Long.valueOf(userId));
        model.addAttribute("contextPath", servletContext.getContextPath());
        
        
        userService.updateUserActiveState(userId.intValue(), 1);
        // userId = userService.updateUserActiveState(userId.intValue(), 1));
        return "chat";
    }

    @RequestMapping(path = "/chatLogin", method = RequestMethod.GET)
    public String showLoginPage() 
    {
        return "chatLogin";
    }

    @RequestMapping(path = "/doChatLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) 
    {
        username = username.trim();

        if (username.isEmpty()) 
        {
            return "chatLogin";
        }

//        UserEntity user = new UserEntity();
//        user.setUsername(username);
//        user = userService.saveUser(user);
//        
        UserModel user = service2.getCurrentUser();
        System.out.println(user.getUsername());
        
        if (username.equals(user.getUsername()))
        {
	        request.getSession().setAttribute("user_Id", user.getId());
	        request.getSession().setAttribute("username", user.getUsername());
	        
	        return "redirect:/chat/";
        }
//        request.getSession().setAttribute("user_Id", user.getId());
//        request.getSession().setAttribute("username", user.getUsername());
        
        return "chatLogin";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) 
    {
        request.getSession(true).invalidate();

        return "redirect:/chat/chatLogin";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request, Model model) 
    {

    	String userName = (String)request.getSession().getAttribute("username");
        Long userId = (Long)request.getSession().getAttribute("user_Id");

        if (userName == null || userName.isEmpty() || userId == null) 
        {
            return "redirect:/chat/chatLogin";
        }

        model.addAttribute("username", userName);
        model.addAttribute("user_Id", userId);
        model.addAttribute("contextPath", servletContext.getContextPath());

        return "search";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSearch(HttpServletRequest request, @RequestParam() Integer search_type,
                           @RequestParam(defaultValue = "") String content) 
    {
        content = content.trim();

        if (!content.isEmpty()) {

            if (search_type.intValue() == 0) 
            {
                // Do Search for text in messages
                List<Message> messageslist = messageService.searchForTextinMessages(content);
                Gson gsonBuilder = new GsonBuilder().create();
                String messagelistJson = gsonBuilder.toJson(messageslist);
                return messagelistJson;
            } 
            else
            {
                // Do Search for messages by user name
                List<Message> messageslist = messageService.searchForMessagesbyUserName(content);
                Gson gsonBuilder = new GsonBuilder().create();
                String messagelistJson = gsonBuilder.toJson(messageslist);
                return messagelistJson;
            }
        }
        return null;
    }

    @RequestMapping(value = "/getActiveUsers", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getActiveUsers(HttpServletRequest request, HttpServletResponse response) 
    {
        // Get User list and last 3 messages
        List<UserEntity> userlist = userService.getActiveUserList();
        Gson gsonBuilder = new GsonBuilder().create();
        String userlistJson = gsonBuilder.toJson(userlist);
        return userlistJson;

    }

    @RequestMapping(value = "/getLastMessages", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getLastMessages(HttpServletRequest request, HttpServletResponse response) 
    {
        // Get User list and last 3 messages
        List<Message> messageslist = messageService.getLastMessages();
        Gson gsonBuilder = new GsonBuilder().create();
        String messagelistJson = gsonBuilder.toJson(messageslist);
        return messagelistJson;
    }
}