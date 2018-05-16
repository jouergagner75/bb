package com.backbase.atms;

import com.backbase.location.rest.spec.v1.locations.LocationsApi;
import com.backbase.location.rest.spec.v1.locations.LocationsGetResponseBody;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luca
 * @version 1.0
 * @since 07/11/2017
 * <p>
 * Imagination is more important than knowledge. @AE
 */
// TODO 8 (optional) :  make class as a RestController Spring Bean and remove @RestController annotation from AtmLocationsRestController class
public class AtmLocationsController implements LocationsApi {

    @EndpointInject(uri = AtmLocationsRoute.DIRECT_GET)
    private ProducerTemplate atmLocationsRoute;

    @Override
    public LocationsGetResponseBody getLocations(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        return (LocationsGetResponseBody) atmLocationsRoute.requestBody(null);
    }

}