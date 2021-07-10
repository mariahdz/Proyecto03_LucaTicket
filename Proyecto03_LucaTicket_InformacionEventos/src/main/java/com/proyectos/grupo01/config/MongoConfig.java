//package com.proyectos.grupo01.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoClientSettingsFactoryBean;
//
//
//
//public class MongoConfig {
//	
//	@Value("${spring.data.mongodb.port}")
//    private String mongoPort;
//
//    @Value("${spring.data.mongodb.database}")
//    private String mongoDB;
//
//    /*Client vs FactoryClient
//     * 
//     * Factory bean that creates the com.mongodb.MongoClient instance
//     * 
//     * Classes attributed with @repostiory may throw mongo related exceptions. Declaring an instance of MonogClientFactoryBean
//     * helps in translating them to spring data exceptions which can then be caught using @ExceptionHandling
//*/
//     public @Bean MongoClientSettingsFactoryBean mongo() throws Exception {
//    	 MongoClientSettingsFactoryBean mongo = new MongoClientSettingsFactoryBean();
//          mongo.setClusterSrvHost("localhost");
//          MongoClientOptions clientOptions = MongoClientOptions.builder().applicationName("Evento")
//                  .connectionsPerHost(2000)
//                  .connectTimeout(4000)
//                  //.maxConnectionIdleTime(1000000000)
//                  .maxWaitTime(3000)
//                  .retryWrites(true)
//                  .socketTimeout(4000)
//                  .sslInvalidHostNameAllowed(true)//this is very risky
//
//                  .build();
//         mongo.getObjectType();
//
//
//          return mongo;
//     }
//}
//
//
