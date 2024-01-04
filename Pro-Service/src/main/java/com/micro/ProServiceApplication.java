package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProServiceApplication.class, args);
	}

}
