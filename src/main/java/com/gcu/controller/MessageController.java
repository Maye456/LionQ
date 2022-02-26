package com.gcu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.MessageModel;
import com.gcu.service.MessageService;
import com.gcu.service.UserService;

@RestController
@CrossOrigin
public class MessageController
{
	@Autowired
	UserService userService;
	
    @Autowired
    MessageService messageService;
    
    // Used in websocket communication where client (Front End) will send a message to a specific destination 
    @MessageMapping("/chat/{to}")
    public void sendMessagePersonal(@DestinationVariable String to, MessageModel message) 
    {
        messageService.sendMessage(to, message);
    }

    // Used in Rest API communication for method GET to get a response data.
    @GetMapping("listmessage/{from}/{to}")
    public List<Map<String,Object>> getListMessageChat(@PathVariable("from") Integer from, @PathVariable("to") Integer to)
    {
        return messageService.getListMessage(from, to);
    }

    // Used in Rest API communication for method GET to get a response data.
    @GetMapping("/fetchAllUsers/{myId}")
    public List<Map<String,Object>> fetchAll(@PathVariable("myId") String myId) 
    {
        return userService.fetchAll(myId);

    }
}