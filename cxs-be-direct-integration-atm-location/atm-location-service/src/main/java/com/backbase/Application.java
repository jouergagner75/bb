package com.backbase;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Alejandro Aguirre
 **/
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String... args) {
        build(new SpringApplicationBuilder()).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return build(springApplicationBuilder);
    }

    private static SpringApplicationBuilder build(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(Application.class);
    }

}
