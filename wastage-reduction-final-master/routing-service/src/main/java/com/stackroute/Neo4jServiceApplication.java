package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.stackroute.repository")
@EnableEurekaClient
public class Neo4jServiceApplication {

	public static void main(String []args) {

		SpringApplication.run(Neo4jServiceApplication.class, args);
	}

}
