package com.qianlq.feignserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServerApplication.class, args);
    }
}
