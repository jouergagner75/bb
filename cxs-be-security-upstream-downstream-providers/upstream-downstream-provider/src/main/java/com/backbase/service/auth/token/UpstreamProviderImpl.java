package com.backbase.service.auth.token;

import com.backbase.buildingblocks.jwt.core.token.JsonWebTokenClaimsSet;
import com.backbase.buildingblocks.logging.api.Logger;
import com.backbase.buildingblocks.logging.api.LoggerFactory;
import com.backbase.buildingblocks.token.converter.api.dto.UpstreamTokenConverterData;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

/**
 * used to provide extra HTTP headers for upstream services. For instance, we can take the subject
 * name from the Authentication object and push it into the upstream headers
 *
 */
//TODO 5: Make this class implement UpstreamProvider interface
@Service
public class UpstreamProviderImpl {

    private static final Logger logger = LoggerFactory.getLogger(UpstreamProviderImpl.class);

    public static final String TIME_TO_TOKEN_RENEWAL_POPUP_HEADER = "TimeToTokenRenewalWindowPopup";

    public UpstreamTokenConverterData getUpstreamData(HttpServletRequest httpServletRequest, Authentication authentication) throws Exception {

        JsonWebTokenClaimsSet claimsSet = (JsonWebTokenClaimsSet) authentication.getDetails();
        // TODO 6: Assign the EXPIRATION_TIME claim to utcTimeInSeconds variable
        Long utcTimeInSeconds = (Long) null;

        LocalDateTime expirationTime = Instant.ofEpochSecond(utcTimeInSeconds).atZone(ZoneId.systemDefault()).toLocalDateTime();

        Long timeToLiveSeconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), expirationTime);

        Set<Cookie> additionalCookies = new HashSet<>();

        // TODO 7: Assign to cookie variable a new instance of Cookie with TIME_TO_TOKEN_RENEWAL_POPUP_HEADER key and timeToLiveSeconds value
        Cookie cookie = null;
        // TODO 8: Set the max age of cookie as timeToLiveSeconds

        additionalCookies.add(cookie);

        logger.debug("additionalCookies: {}", additionalCookies);

        // TODO 9: Return a new intance of UpstreamTokenConverterData containing the additionalCookies
        return null;
    }
}