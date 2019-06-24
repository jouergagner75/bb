package com.backbase.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alejandro Aguirre
 * @since 24-06-2019
 **/
public class GeoLocation {
    @JsonProperty("GeographicCoordinates")
    private GeographicCoordinates geographicCoordinates = null;

    public GeographicCoordinates getGeographicCoordinates() {
        return geographicCoordinates;
    }

    public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
        this.geographicCoordinates = geographicCoordinates;
    }
}
