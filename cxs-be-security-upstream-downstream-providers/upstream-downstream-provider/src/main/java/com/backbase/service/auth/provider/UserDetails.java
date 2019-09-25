package com.backbase.service.auth.provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Stores additional details about the authentication request.
 */
public class UserDetails {

    private String username;
    private String name;
    private Boolean mobileActive;
    private String partyId;


    public UserDetails(String username, String name, Boolean mobileActive, String partyId) {
        this.username = username;
        this.name = name;
        this.mobileActive = mobileActive;
        this.partyId = partyId;
    }

    public Boolean getMobileActive() {
        return this.mobileActive;
    }

    public String getPartyId() { return this.partyId; }
}
