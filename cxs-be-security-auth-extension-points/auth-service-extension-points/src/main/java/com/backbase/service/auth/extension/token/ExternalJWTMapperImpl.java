package com.backbase.service.auth.extension.token;

import com.backbase.buildingblocks.jwt.external.token.ExternalJwtClaimsSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static com.backbase.service.auth.common.CustomClaimsNames.TRANSFER_WISE_TOKEN_CLAIM_NAME;

/**
 * Class used to add extra claims to the External JWT Token
 */
@Component
@Slf4j
//TODO 1: Make this class implement ExternalJwtMapper interface
public class ExternalJWTMapperImpl {

    //TODO 2: Add the TransferWise token as an extra claim. Use the com.backbase.service.auth.common.CustomClaimsNames.TRANSFER_WISE_TOKEN_CLAIM_NAME as the key name

    public Optional<ExternalJwtClaimsSet> claimSet(Authentication authentication, HttpServletRequest request) {
        log.info("Adding extra claim to the token: {}", TRANSFER_WISE_TOKEN_CLAIM_NAME);

        return null;

    }

}
