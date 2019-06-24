package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
 **/
public class Location {
    @JsonProperty("Site")
    private Site site = null;

    @JsonProperty("PostalAddress")
    private PostalAddress postalAddress = null;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }
}
