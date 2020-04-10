package com.qianlq.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class AdminDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDashboardApplication.class, args);
    }
}
