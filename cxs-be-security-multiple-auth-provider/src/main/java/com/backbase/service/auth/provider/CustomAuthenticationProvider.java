package com.backbase.service.auth.provider;

import com.backbase.service.auth.domain.CustomExternalUser;
import com.backbase.service.auth.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

/**
 * In some scenarios we will still need to access the full Authentication request to be able to perform the
 * authentication process – for example when authenticating against some external, third party service – both the
 * username and the password from the authentication request will be necessary. For these, more advanced scenarios,
 * we’ll need to define a custom Authentication Provider
 */

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final String EXT_MANAGER = "business_manager";
    private static final String MANAGER = "ROLE_MANAGER";
    private static final String GROUP_MANAGER_MANAGER = "ROLE_group_manager(MANAGER)";

    private final CustomUserService customUserService;

    @Override
    public Authentication authenticate(Authentication authentication) {

        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        final CustomExternalUser customUser = customUserService.retrieveUser(username, password);

        // return null to let the other authentication provider to search for this user
        if (customUser == null || !customUser.getUsername().equalsIgnoreCase(username)) {
            return null;
        }

        throwBadCredentialsWhenEmptyOrNull(username, customUser);

        List<GrantedAuthority> grantedAuth = mapExternalRolesToBackbaseRoles(customUser);

        return new UsernamePasswordAuthenticationToken(customUser, null, grantedAuth);

    }

    private List<GrantedAuthority> mapExternalRolesToBackbaseRoles(CustomExternalUser customUser) {
        if (EXT_MANAGER.equals(customUser.getGroup())) {
            return Stream.of(MANAGER, GROUP_MANAGER_MANAGER)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }
        return emptyList();
    }

    private void throwBadCredentialsWhenEmptyOrNull(String username, CustomExternalUser customUser) {
        if (customUser == null || !customUser.getUsername().equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Bad credential");
        }

        if (customUser.getGroup() == null) {
            throw new BadCredentialsException("Missing Group");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}