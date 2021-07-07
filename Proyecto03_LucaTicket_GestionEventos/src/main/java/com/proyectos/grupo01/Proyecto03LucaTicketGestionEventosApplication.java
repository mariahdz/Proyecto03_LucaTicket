package com.proyectos.grupo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Proyecto03LucaTicketGestionEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto03LucaTicketGestionEventosApplication.class, args);
	}

}
