package com.backbase.atms;

import com.backbase.location.rest.spec.v1.locations.Address;
import com.backbase.location.rest.spec.v1.locations.Coordinates;
import com.backbase.location.rest.spec.v1.locations.Location;
import com.openbankproject.api.model.GeographicCoordinates;
import com.openbankproject.api.model.InlineResponse200ATM;
import com.openbankproject.api.model.PostalAddress;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 *
 * @author luca
 * @version 1.0
 * @since 07/11/2017
 * <p>
 * Imagination is more important than knowledge. @AE
 */
@Component
public class AtmLocationsTransformer {
    /**
     * Transform an ATM object into a Location object
     * @param atm the ATM object from the Open Bank API
     * @return the transformed object
     */
    public static Location transformAtmToLocation(InlineResponse200ATM atm) {
        Location location = new Location();
        location.setId(atm.getIdentification());
        location.setName(atm.getLocation().getSite().getName());
        location.setType("ATM");

        if (getPostalAddress(atm).getGeoLocation() != null) {
            Coordinates coord = new Coordinates();
            coord.setLatitude(new BigDecimal(getGeographicCoordinates(atm).getLatitude()));
            coord.setLongitude(new BigDecimal(getGeographicCoordinates(atm).getLongitude()));
            location.setCoordinates(coord);
        }

        if (getPostalAddress(atm) != null) {
            Address address = new Address();
            address.setNameOrNumber(getPostalAddress(atm).getBuildingNumber());
            address.setStreet(getPostalAddress(atm).getStreetName());
            address.setTown(getPostalAddress(atm).getTownName());
            address.setCountry(getPostalAddress(atm).getCountry());
            address.setPostcode(getPostalAddress(atm).getPostCode());
            location.setAddress(address);
        }

        return location;
    }

    private static  PostalAddress getPostalAddress(InlineResponse200ATM atm) {
        return atm.getLocation().getPostalAddress();
    }

    private static GeographicCoordinates getGeographicCoordinates(InlineResponse200ATM atm) {
        return getPostalAddress(atm).getGeoLocation().getGeographicCoordinates();
    }

}
