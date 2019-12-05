package com.cognizant.smartshopservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SmartshopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartshopServiceApplication.class, args);
	}

}
