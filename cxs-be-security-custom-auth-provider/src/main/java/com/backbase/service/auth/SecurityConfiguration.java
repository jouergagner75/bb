package com.backbase.service.auth;

import com.backbase.buildingblocks.authentication.core.AuthSecurityConfiguration;
import com.backbase.service.auth.provider.CustomAuthenticationProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
//TODO 3 : add the appropriate annotation to enable Spring Security integration with Spring MVC

public class SecurityConfiguration extends AuthSecurityConfiguration {

    //TODO 4 : Autowire and use your custom authentication Provider in the SecurityConfiguration class.


    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //TODO 5 : Use authenticationManagerBuilder to add your Custom Authentication Provider in the list of authentication providers

    }
}