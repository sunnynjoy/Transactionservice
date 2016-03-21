package com.rest.jms.listeners;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.rest.jms.adapters.TransactionConsumerAdapter;

@Component
public class TransactionConsumerListener implements MessageListener {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	TransactionConsumerAdapter transactionConsumerAdapter;

	@Override
	public void onMessage(Message msg) {
		System.out.println("In onMessage()");
		String json = null;
		if(msg instanceof TextMessage){
			try {
				json = ((TextMessage) msg).getText();
				transactionConsumerAdapter.sendToMongo(json);
				jmsTemplate.convertAndSend(json);
			} catch (JMSException e) {
				jmsTemplate.convertAndSend(json);
			} catch (Exception e) {
				jmsTemplate.convertAndSend(json);
			}
		}
	}
}
