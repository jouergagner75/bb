package com.backbase.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ExchangeRateApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(ExchangeRateApplication.class, args);
    }

    @Bean
    public RestTemplate newRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}