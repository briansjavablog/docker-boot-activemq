package com.blog.sample.app;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	
    @JmsListener(destination = "TestQueue", containerFactory = "jmsContainerFactory")
    public String receiveMessage(String message) {
        
    	System.out.println("Received [" + message + "]");
        return message;
    }
}
