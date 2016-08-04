package com.blog.sample.app;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageSender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void publishMessage(final String message){
		
		MessageCreator messageCreator = new MessageCreator() {
           // @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        
        System.out.println("Sending a new message.");
        jmsTemplate.send("TestQueue", messageCreator);
	}
	
}