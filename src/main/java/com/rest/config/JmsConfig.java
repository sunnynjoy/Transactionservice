package com.rest.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.rest.jms.listeners.TransactionConsumerListener;

@Configuration
@EnableAutoConfiguration 
public class JmsConfig {

	 @Bean
	    public JmsTemplate jmsTemplate() {
	        JmsTemplate jmsTemplate = new JmsTemplate();
	        jmsTemplate.setDefaultDestination(new ActiveMQQueue("RME.QUEUE"));
	        jmsTemplate.setConnectionFactory(connectionFactory());
	        return jmsTemplate;
	    }

	    @Bean
	    public ActiveMQConnectionFactory connectionFactory() {
	        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
	        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
	        return activeMQConnectionFactory;
	    }
	    
	    @Bean
	    public TransactionConsumerListener transactionListener(){
	    	return new TransactionConsumerListener();
	    }

}
