package com.blog.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageReceiver(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	// @JmsListener(destination = "TestQueue", containerFactory =
	// "jmsContainerFactory")
	public String retrieveMessage() {

		String message = (String) jmsTemplate.receiveAndConvert("TestQueue");
		System.out.println("Received [" + message + "]");
		return message;
	}
}
