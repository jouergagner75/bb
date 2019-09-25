package com.backbase.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Erkin Pehlivan
 */
@SpringBootApplication
// TODO 2: Use appropriate annotation to enable scheduling (one way to use scheduled jobs: https://spring.io/guides/gs/scheduling-tasks/)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}