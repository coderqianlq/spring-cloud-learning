package com.coderqian.eurekacustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerApplication.class, args);
	}
}
