package com.rest.jms.util;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqConnectionFactory extends ActiveMQConnectionFactory {

	private ActiveMqConnectionFactory() {
		new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	public static Session getSession() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = ActiveMQConnectionFactoryInstance.INSTANCE;
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}

	/*private static ActiveMQConnectionFactory getActiveMQConnectionFactory() {
		if (activeMQConnectionFactory == null) {
			activeMQConnectionFactory = new ActiveMqConnectionFactory();
		}
		return activeMQConnectionFactory;
	}*/
	
	private static class ActiveMQConnectionFactoryInstance {
		private static final ActiveMqConnectionFactory INSTANCE = new ActiveMqConnectionFactory();
	}
}
