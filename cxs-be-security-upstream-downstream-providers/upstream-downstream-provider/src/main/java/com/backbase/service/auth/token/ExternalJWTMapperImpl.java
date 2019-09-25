package com.backbase.service.auth.token;

import com.backbase.buildingblocks.jwt.external.ExternalJwtMapper;
import com.backbase.buildingblocks.jwt.external.token.ExternalJwtClaimsSet;
import com.backbase.buildingblocks.logging.api.Logger;
import com.backbase.buildingblocks.logging.api.LoggerFactory;
import com.backbase.service.auth.provider.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static com.backbase.service.auth.common.Constants.MOBILE_ACTIVE;
import static com.backbase.service.auth.common.Constants.PARTY_ID;

/**
 Class used to add extra claims to the External JWT Token
 */
@Component
public class ExternalJWTMapperImpl implements ExternalJwtMapper {

    private static final Logger logger = LoggerFactory.getLogger(ExternalJWTMapperImpl.class);

    @Override
    public Optional<ExternalJwtClaimsSet> claimSet(Authentication authentication, HttpServletRequest request) {
        Optional<ExternalJwtClaimsSet> response;

        if (authentication == null || !(authentication.getDetails() instanceof UserDetails)) {
            return Optional.empty();
        }

        UserDetails auth = (UserDetails) authentication.getDetails();
        response = Optional.of(new ExternalJwtClaimsSet.Builder()
                .addClaims(new ExternalJwtClaimsSet(Collections.singletonMap(MOBILE_ACTIVE, auth.getMobileActive())))
                .addClaims(new ExternalJwtClaimsSet(Collections.singletonMap(PARTY_ID, auth.getPartyId())))
                .build());

        logger.debug("extraClaims: {}", response);

        return response;
    }

    @Override
    public void updateAuthorities(Set<String> roles, Authentication authentication) {

    }

    public Optional<String> getUserName(Authentication authentication) {
        return Optional.empty();
    }
}
