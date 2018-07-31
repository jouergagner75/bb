package com.backbase.atms;

import com.openbankproject.api.spec.ATMApi;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.camel.language.spel.SpelExpression.spel;

/**
 *
 * Camel route to call OpenBank API and transform the response
 */
//@Component
public class AtmLocationsRoute extends RouteBuilder {

    public static final String DIRECT_GET = "direct:/atms/get";

    private final ATMApi atmApi;

    private final AtmLocationsTransformer atmLocationsTransformer;

    @Autowired
    public AtmLocationsRoute(ATMApi atmApi, AtmLocationsTransformer atmLocationsTransformer) {
        this.atmApi = atmApi;
        this.atmLocationsTransformer = atmLocationsTransformer;
    }

    @Override
    public void configure() throws Exception {
        from(DIRECT_GET)
                .routeId("com.backbase.sample.atms.get")
                //.bean(atmApi, "atmsGet")
                .setBody(spel("#{body.data[0].brand[0].ATM}"))
                .log(LoggingLevel.INFO, "${body.size} ATM locations retrieved")
                // This call will transform each element in parallel
                .split(body(), new GroupedBodyAggregationStrategy()).parallelProcessing()
                .bean(atmLocationsTransformer, "transformAtmToLocation(${body})")
                .end()
                // Wrap the list of Locations into a response wrapper
                .setBody(spel("#{new com.backbase.location.rest.spec.v1.locations.LocationsGetResponseBody().withLocations(body)}"));
    }

    /**
     * Simple aggregation strategy which joins the bodies of multiple exchanges into a single list
     */
    public class GroupedBodyAggregationStrategy extends AbstractListAggregationStrategy<Object> {
        @Override
        public Object getValue(Exchange exchange) {
            return exchange.getIn().getBody();
        }
    }

}

