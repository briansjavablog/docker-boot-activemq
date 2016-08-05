package com.blog.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
		this.jmsTemplate = jmsTemplate;
		this.jmsTemplate.setMessageConverter(messageConverter);
	}

	// @JmsListener(destination = "TestQueue", containerFactory =
	// "jmsContainerFactory")
	public String retrieveMessage() {

		String message = (String) jmsTemplate.receiveAndConvert("TestQueue");
		log.info("Retrieved message from queue: " + message);
		return message;
	}
}
