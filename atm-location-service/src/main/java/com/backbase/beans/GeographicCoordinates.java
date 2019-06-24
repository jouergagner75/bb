package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
 **/
public class GeographicCoordinates {
    @JsonProperty("Latitude")
    private String latitude = null;

    @JsonProperty("Longitude")
    private String longitude = null;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
