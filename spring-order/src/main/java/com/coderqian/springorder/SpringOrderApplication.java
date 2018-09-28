package com.coderqian.springorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOrderApplication.class, args);
	}
}
