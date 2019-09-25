package com.backbase.service.auth.provider;

import com.backbase.service.auth.service.CustomUserService;
import com.backbase.service.auth.service.dao.CustomExternalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 In some scenarios we will still need to access the full Authentication request to be able to
 perform the authentication process – for example when authenticating against some external,
 third party service –
 both the username and the password from the authentication request will be necessary.
 For these, more advanced scenarios, we’ll need to define a custom Authentication Provider
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    public static final String EXT_MANAGER = "business_manager";
    public static final String MANAGER = "ROLE_MANAGER";
    public static final String GROUP_MANAGER_MANAGER = "ROLE_group_manager(MANAGER)";

    @Autowired
    private CustomUserService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final String username = (String) authentication.getPrincipal();
        final String password = (String) authentication.getCredentials();
        final CustomExternalUser customUser = service.retrieveUser(username, password);

        if (customUser == null || !customUser.getUsername().equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Bad credential");
        }

        if (customUser.getGroup() == null) {
            throw new BadCredentialsException("Missing Group");
        }

        List<GrantedAuthority> grantedAuth = null;

        if (EXT_MANAGER.equals(customUser.getGroup())) {
            Collection<String> roles = Arrays.asList(MANAGER, GROUP_MANAGER_MANAGER);
            grantedAuth = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());
        }

        UsernamePasswordAuthenticationToken authenticatedToken = new UsernamePasswordAuthenticationToken(customUser.getUsername(), null, grantedAuth);
        UserDetails dummy = new UserDetails(customUser.getUsername(), customUser.getFirstName(), customUser.getMobileActive(), customUser.getPartyId());
        authenticatedToken.setDetails(dummy);

        return authenticatedToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
