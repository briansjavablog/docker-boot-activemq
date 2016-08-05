package com.blog.sample.app;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object messageObject, Session session) throws JMSException, MessageConversionException {

		SimpleMessage simpleMessage = (SimpleMessage) messageObject;
		MapMessage message = session.createMapMessage();
		message.setString("message", simpleMessage.toString());
		return message;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {

		MapMessage mapMessage = (MapMessage) message;
		return mapMessage.getString("message");
	}

}