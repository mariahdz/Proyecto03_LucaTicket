package com.proyectos.grupo01.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.env.Environment;
//
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClientFactory;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import com.proyectos.grupo01.model.Mongo;
//
//	@Configuration
//	@Import(value=MongoClientFactory.class)
//	public class DataSourceConfig {
//
//	//    @Qualifier
//	  //  MongoClient mongo;
//	    
//	    @Autowired
//	    Mongo mongos;
//
//	    @Autowired
//	    Environment env;
//
//	    @Bean
//	    public String test() {
//	        System.out.println("mongo"+mongo);
//	        return "rer";
//	    }
//	    
//	    MongoClient mongo = MongoClients.create("mongodb+srv://Desiree:daniela123@lucaticket.hm7ea.mongodb.net/Evento?retryWrites=true&w=majority");
//	    
//	    public MongoDatabase connect(String host, int port, String database) {
//		    // Create serverAddress, the location a MongoDB server
//		   // ServerAddress serverAddress = new ServerAddress("lucaticket-shard-00-02.hm7ea.mongodb.net:27017"
//	//, 27017);
//
//		    // Connect to the MongoDB server with internal connection pooling
//		    
//		    MongoClient mongoClient = MongoClients.create("mongodb+srv://Desiree:daniela123@lucaticket.hm7ea.mongodb.net/Evento?retryWrites=true&w=majority");
//		    
//		    // Getting a connection easily avoiding ServerAddress
//		    // mongoClient = new MongoClient(host, port);
//		    
//		    // Select the database
//		    MongoDatabase db = mongoClient.getDatabase(database);
//
//		    return db;
//
//		  }
//
//	
//
//	    @Bean
//	    @Qualifier("customMongoTemplate")
//	    public MongoTemplate mongoTemplate() {
//	    	
//	    	
//
//	        //MongoClient is the actual pool used by mongo. Create it using client factory then, autoclosing of threads are handled on its own
//	        SimpleMongoClientDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(mongo, "mongo_test");
//	        MongoTemplate template = new MongoTemplate(factory);
//	        
//
//	        return template;
//	    }
//
//	    @Bean
//	    @Qualifier(value="customMongoOps")
//	    public MongoOperations mongoOps() {
//	        MongoOperations ops = mongoTemplate();
//	        return ops;
//	    }
//
//
//	    @Bean
//	    public SimpleMongoClientDatabaseFactory factory() {
//	        SimpleMongoClientDatabaseFactory factory = new SimpleMongoClientDatabaseFactory (mongo, "mongo_test");
//	        return factory;
//	    }
//
//	//  @Bean
//	//  public GridFsTemplate gridFsTemplate() {
////	      return new GridFsTemplate(mongo, converter)
//	//  }
//
//
//}
//
//
