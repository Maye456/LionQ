package com.gcu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.gcu.model.MessageModel;

@Service
public class MessageService 
{
	// Used to send messages to users who have subscribed to specific topics
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    // websocket personal chat to storing a message into database and send back to destination subscribe topic
    public void sendMessage(String to, MessageModel message) 
    {
        jdbcTemplate.update(
        		"INSERT INTO messages (message_text, message_from, message_to, created_datetime) "
        		+ "VALUES (?, ?, ?, current_time )", message.getMessage(), message.getFromLogin(), to);

        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);

    }

    // Used in Rest Api to retrieve a list of messages from personal user to another user chat
    public List<Map<String,Object>> getListMessage(@PathVariable("from") Integer from, @PathVariable("to") Integer to)
    {
        return jdbcTemplate.queryForList(
        		"SELECT * FROM messages WHERE (message_from = ? and message_to = ?) " +
                "OR (message_to = ? and message_from = ?) ORDER BY created_datetime ASC", from, to, from, to);
    }
}