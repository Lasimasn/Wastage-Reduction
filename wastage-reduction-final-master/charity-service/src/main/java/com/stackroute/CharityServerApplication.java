package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CharityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharityServerApplication.class, args);
	}

}
