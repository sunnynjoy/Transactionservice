package com.rest.jms.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiConnectionFactory {

	private static Connection connection;

	private JndiConnectionFactory() {
		try {
			Context context = new InitialContext();
			connection = ((ConnectionFactory)context.lookup("ConnectionFactory")).createConnection();
		} catch (NamingException | JMSException e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() throws JMSException {
		Connection connection = getConnectionFactory();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}

	private static Connection getConnectionFactory() {
		if (connection == null) {
			new JndiConnectionFactory();
		}
		return connection;
	}
}
