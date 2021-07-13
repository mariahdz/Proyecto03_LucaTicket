package com.proyectos.grupo01.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Application Config
 * @author María Hernández
 * @version 09/07/2021/A
 *
 */
@Configuration
@EnableMongoRepositories(basePackages="com.proyectos.grupo01.repository")
public class ApplicationConfig extends AbstractMongoClientConfiguration {
	
	@Autowired
	private Environment env;
	
	protected String getDatabaseName () {
		return env.getProperty("mongodb.database");
	}
	
	public MongoClient mongoClient() {
		
		ConnectionString connectionString = new ConnectionString(env.getProperty("mongodb.connection.string"));
		
		
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
	
		return MongoClients.create(mongoClientSettings);
	}
	
	protected Collection <String> getMappingBasePackages(){
		return Collections.singleton("com.proyectos.grupo01");
	}
	

}
