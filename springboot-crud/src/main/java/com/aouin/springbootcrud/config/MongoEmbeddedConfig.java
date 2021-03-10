package com.aouin.springbootcrud.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class MongoEmbeddedConfig {
	
	 private static final String MONGO_DB_URL = "${spring.data.mongodb.host}";
	 private static final String MONGO_DB_NAME = "${spring.data.mongodb.database}";
	 private static final int MONGO_DB_PORT = Integer.parseInt("${spring.data.mongodb.port}");
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws IOException {
	        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	        mongo.setBindIp(MONGO_DB_URL);
	        mongo.setPort(MONGO_DB_PORT);
	        MongoClient mongoClient = (MongoClient) mongo.getObject();
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
	        return mongoTemplate;
	    }
}
