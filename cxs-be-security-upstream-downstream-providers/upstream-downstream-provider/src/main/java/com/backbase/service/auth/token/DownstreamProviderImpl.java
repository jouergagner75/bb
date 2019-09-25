package com.backbase.service.auth.token;

import com.backbase.buildingblocks.jwt.core.token.JsonWebTokenClaimsSet;
import com.backbase.buildingblocks.logging.api.Logger;
import com.backbase.buildingblocks.logging.api.LoggerFactory;
import com.backbase.buildingblocks.token.converter.api.DownstreamProvider;
import com.backbase.buildingblocks.token.converter.api.dto.DownstreamTokenConverterData;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

import static com.backbase.service.auth.common.Constants.PARTY_ID;

/**
 * This class can be used to provide extra HTTP headers for downstream services. For instance, we can take the subject
 * name from the Authentication object and push it into the downstream headers
 *
 */
//TODO 1: Make this class implement DownstreamProvider interface
@Service
public class DownstreamProviderImpl {

    private static final Logger logger = LoggerFactory.getLogger(DownstreamProviderImpl.class);

    public DownstreamTokenConverterData getDownstreamData(HttpServletRequest httpServletRequest, Authentication authentication) throws Exception {
        JsonWebTokenClaimsSet claimsSet = (JsonWebTokenClaimsSet) authentication.getDetails();
        // TODO 2: Assign the value of Constants.PARTY_ID claim to partyId variable
        String partyId = null;

        // TODO 3: Assign a Map to additionalHeaders variable with Constants.PARTY_ID key and partyId value
        Map<String, String> additionalHeaders = null;

        logger.debug("additionalHeaders: {}", additionalHeaders);

        // TODO 4: Return a new instance of DownstreamTokenConverterData containing the additionalHeaders
        return null;
    }
}