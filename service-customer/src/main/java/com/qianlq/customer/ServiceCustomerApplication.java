package com.qianlq.customer;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.qianlq.support"})
@SpringBootApplication(exclude = {PageHelperAutoConfiguration.class}, scanBasePackages = {"com.qianlq.support", "com.qianlq.customer"})
public class ServiceCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerApplication.class, args);
    }
}
