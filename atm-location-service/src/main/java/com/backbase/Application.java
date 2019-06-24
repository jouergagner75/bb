package com.backbase;

import com.backbase.buildingblocks.backend.configuration.autoconfigure.BackbaseApplication;
import com.backbase.buildingblocks.jwt.internal.config.EnableInternalJwtConsumer;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
 **/
@BackbaseApplication
@EnableInternalJwtConsumer
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
