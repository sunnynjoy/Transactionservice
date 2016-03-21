package com.rest.jms.adapters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransactionConsumerAdapterTest {
	
	private String json = "{firstName:\"tet\",lastName:\"tr\",company:\"govt\"}";
	
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
		
	}	

	@Test
	public void testSendToMongo() {
		TransactionConsumerAdapter transactionConsumerAdapter = new TransactionConsumerAdapter();
		transactionConsumerAdapter.sendToMongo(json);
		assertNotNull(json);
	}
}
