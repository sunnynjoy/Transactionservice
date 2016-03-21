package com.jms.senderReceiver;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import com.rest.jms.util.ActiveMqConnectionFactory;

public class JmsAsynReceiver implements MessageListener {

	public JmsAsynReceiver() {
		super();
		try {
			Session session = ActiveMqConnectionFactory.getSession();
			Queue queue = session.createQueue("TMP.Q");
			MessageConsumer messageConsumer = session.createConsumer(queue);
			messageConsumer.setMessageListener(this);
			System.out.println("waiting for messages");
		} catch (Exception e) {

		}
	}

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			System.out.println("Text Message is "+ textMessage);
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		Runnable run = () ->
		{
			new JmsAsynReceiver();
		};
		new Thread(run).start();
	}

}
