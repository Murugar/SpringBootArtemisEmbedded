package com.iqmsoft;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	private final JmsTemplate jmsTemplate;

	@Autowired
    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
	
	
		
		
	@Scheduled(fixedRate=1000)
	public void send() throws JMSException {
		sendMessage("Test");
		System.out.println("Sending Message..."); 
	}
	
	
	public void sendMessage(final String message){
		jmsTemplate.send("exampleQueue", new MessageCreator() {
	        @Override
			public Message createMessage(Session session) throws JMSException {

	            return session.createTextMessage(message);
	        }
	    });
		
	}

}
