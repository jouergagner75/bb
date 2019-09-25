package com.backbase.service.auth.dao;

import com.backbase.service.auth.domain.CustomExternalUser;
import org.springframework.stereotype.Repository;

import static java.util.UUID.randomUUID;

/**
 * Emulation of a call to an external auth service or system
 */
@Repository
public class UserDAOImpl {
    private static final String BUSINESS_MANAGER_GROUP = "business_manager";

    public CustomExternalUser loadUserByUsernameAndPassword(final String username, final String password) {
        //just hardcoding the user
        return CustomExternalUser.builder()
                .firstName("Vanessa")
                .lastName("White")
                .mobileActive(true)
                .partyId(randomUUID().toString())
                .username(username)
                .group(BUSINESS_MANAGER_GROUP)
                .build();
    }
}