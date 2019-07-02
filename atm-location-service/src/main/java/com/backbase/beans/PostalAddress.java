package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 **/
public class PostalAddress {

    @JsonProperty("GeoLocation")
    private GeoLocation geoLocation = null;

    @JsonProperty("BuildingNumber")
    private String buildingNumber = null;

    @JsonProperty("StreetName")
    private String streetName = null;

    @JsonProperty("TownName")
    private String townName = null;

    @JsonProperty("Country")
    private String country = null;

    @JsonProperty("PostCode")
    private String postCode = null;

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
