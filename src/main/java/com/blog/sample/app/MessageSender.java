package com.blog.sample.app;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageSender {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageSender(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
		this.jmsTemplate = jmsTemplate;
		this.jmsTemplate.setMessageConverter(messageConverter);		
	}

	public void publishMessage(SimpleMessage simpleMessage){
		
		/*MessageCreator messageCreator = new MessageCreator() {
           // @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(simpleMessage);
            }
        };*/
        
        log.info("Sending message to queue: " + simpleMessage.toString());
        jmsTemplate.convertAndSend("TestQueue", simpleMessage);
	}
	
}