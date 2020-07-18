package com.stackroute.registrationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistrationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServerApplication.class, args);
	}

}
