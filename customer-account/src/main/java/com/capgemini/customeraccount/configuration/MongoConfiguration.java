package com.capgemini.customeraccount.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {

	@Bean
	public MongoClient getMongoClient() {
		MongoClient client = new MongoClient("localhost", 27017);	
		return client;
	}

}
