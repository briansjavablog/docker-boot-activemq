package com.blog.sample.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.sample.app.model.SimpleMessage;
import com.blog.sample.app.mq.MessageReceiver;
import com.blog.sample.app.mq.MessageSender;

@RestController
public class MessageController {

	private final MessageSender messageSender;
	private final MessageReceiver messageReceiver;

	@Autowired
	public MessageController(MessageSender messageSender, MessageReceiver messageReceiver){
		this.messageSender = messageSender;
		this.messageReceiver = messageReceiver;
	}
	
	@RequestMapping(value = "/message/", method = RequestMethod.GET)
	public String retrieveMessage() {
	
		return messageReceiver.retrieveMessage();
	}
		
	@RequestMapping(value = { "/message" }, method = { RequestMethod.POST })
	public void publishMessage(@RequestBody String message) {

		SimpleMessage simpleMessage = new SimpleMessage(message, new Date());
		messageSender.publishMessage(simpleMessage);
	}

}