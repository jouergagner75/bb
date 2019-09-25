package com.backbase.service.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableDiscoveryClient
// TODO 1 : Disable the /login controller from the default auth endpoint
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}