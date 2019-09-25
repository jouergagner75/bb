package com.backbase.peachtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TransactionsApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(TransactionsApplication.class, args);
    }

}