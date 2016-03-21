package com.rest.jms.adapters;

import org.bson.Document;
import org.springframework.stereotype.Component;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class TransactionConsumerAdapter {

	public void sendToMongo(String json) {
		System.out.println("Sneding to mongodb...");
		try(MongoClient mongoClient = new MongoClient()){
			MongoDatabase mongoDatabase = mongoClient.getDatabase("bench1");
			MongoCollection<Document> collection = mongoDatabase.getCollection("demo");
			collection.insertOne(Document.parse(json));
		};
	}
}
