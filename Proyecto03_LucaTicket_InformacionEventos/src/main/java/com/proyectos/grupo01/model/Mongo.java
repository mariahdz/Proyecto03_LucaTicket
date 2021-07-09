package com.proyectos.grupo01.model;

import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Component
public class Mongo {
	
	public MongoDatabase connect(String host, int port, String database) {
	    // Create serverAddress, the location a MongoDB server
	   // ServerAddress serverAddress = new ServerAddress("lucaticket-shard-00-02.hm7ea.mongodb.net:27017"
//, 27017);

	    // Connect to the MongoDB server with internal connection pooling
	    
	    MongoClient mongoClient = MongoClients.create("mongodb+srv://Desiree:daniela123@lucaticket-shard-00-02.hm7ea.mongodb.net:27017");
	    
	    // Getting a connection easily avoiding ServerAddress
	    // mongoClient = new MongoClient(host, port);
	    
	    // Select the database
	    MongoDatabase db = mongoClient.getDatabase(database);

	    return db;

	  }

}
