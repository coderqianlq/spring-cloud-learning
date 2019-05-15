package com.qianlq.consulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulServerApplication.class, args);
	}

}

