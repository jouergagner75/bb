package com.backbase.integration.transactions;

import com.backbase.buildingblocks.backend.configuration.autoconfigure.BackbaseApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@BackbaseApplication
@EnableHystrix
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}