package com.backbase;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


// TODO 3: Use the annotation created by Backbase to run the application and scan the com.backbase packages
// Look for the documentation https://community.backbase.com/documentation/ServiceSDK/latest/service_sdk_ref_configuration
// TODO 4: Enable the Internal JWT Consumer
// TODO 5: Enable registration of the service on the Registry
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
