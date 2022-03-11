/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Websocket configuration to handle messaging
 */

package com.gcu;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{
	// Used for setting websocket endpoint connection into WebSocket
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry)
	{
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
	}
	
	
	// Used for setting application destination prexies websocket and enable simple broker for topic 
	// to subscribe in the project websocket
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry)
	{
		registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic");
	}
}
