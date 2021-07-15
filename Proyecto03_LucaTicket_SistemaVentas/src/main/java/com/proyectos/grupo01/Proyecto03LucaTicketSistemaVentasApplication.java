package com.proyectos.grupo01;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Proyecto03LucaTicketSistemaVentasApplication() {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto03LucaTicketSistemaVentasApplication.class, args);
	}
	
}