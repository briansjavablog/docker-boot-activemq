package com.blog.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {

	@Autowired
	private MessageSender messageSender;
	
	@RequestMapping(value = "/message/", method = RequestMethod.GET)
	public String retrieveMessage() {
	
		return "testMessage";
	}
		
	@RequestMapping(value = { "/message" }, method = { RequestMethod.POST })
	public void publishMessage(@RequestBody String message) {

		messageSender.publishMessage(message);
	}

}