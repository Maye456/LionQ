package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import com.gcu.data.MessageService;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.ChatMessage;
import com.gcu.model.Message;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserDataServiceForRepository userService;

    // Send a message 
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        if (chatMessage.getType() == ChatMessage.MessageType.CHAT) {
            Message message = new Message();
            message.setContent(chatMessage.getContent());
            message.setUsername(chatMessage.getSender());
            message.setUser_id(chatMessage.getSender_id());
            messageService.saveMessage(message);
        }
        return chatMessage;
    }

    // Adds a user to the user list
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        headerAccessor.getSessionAttributes().put("user_Id", chatMessage.getSender_id());

        userService.updateUserActiveState(chatMessage.getSender_id(), 1);

        return chatMessage;
    }

}
