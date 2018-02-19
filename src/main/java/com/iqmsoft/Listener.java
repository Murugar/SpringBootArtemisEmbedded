package com.iqmsoft;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	private TextMessage mapMessage = null;
	private String lastMessage = null;

	public Listener() {
		System.out.println("BootExampleListener Constructor called");
	}

	@JmsListener(destination = "exampleQueue")
	public void processMessage(Message message) throws JMSException {
		System.out.println("processMessage!!!");
		
			mapMessage = (TextMessage) message;
			
		
		System.out.println("MESSAGE RECEIVED: " + mapMessage.getText());
	}
	
	


}
