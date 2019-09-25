package com.backbase.service.auth;

import com.backbase.buildingblocks.authentication.core.AuthSecurityConfiguration;
import com.backbase.service.auth.provider.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends AuthSecurityConfiguration {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    // TODO 2: inject ldap configuration properties (userDnPatter, searchBase, url, passwordAttribute) from yml file

    private String userDnPatter;

    private String searchBase;

    private String url;

    private String passwordAttribute;

    public SecurityConfiguration(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        // TODO 3: add your Custom Authentication Provider in the list of authentication providers

        // TODO 4: Add the ldap authentication configuration here (For the password encoder use the method passwordEncoder() below)
        // HINT check https://spring.io/guides/gs/authenticating-ldap/

    }

    private PasswordEncoder passwordEncoder() {
        final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return bCrypt.encode(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return bCrypt.matches(rawPassword, encodedPassword);
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptEncoder() {
        return new BCryptPasswordEncoder();
    }
}