package com.backbase.integration.transactions.routes;

import com.backbase.integration.transactions.processors.PostTransactionsProcessor;
import com.backbase.integration.transactions.beans.Transactions;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Erkin Pehlivan
 * @since 17/07/2018
 */
// TODO 2: make class Spring Bean and extend from RouteBuilder
public class TransactionsRoute {

    private static final String CONSUMER_ENDPOINT = "activemq:transactions-custom-integration";
    private static final String ROUTE_ID = "com.backbase.training.transactions.getTransactions";

    // TODO 3: define and inject field with the type of PostTransactionsProcessor

    @Override
    public void configure() {
        from(CONSUMER_ENDPOINT)
                .routeId(ROUTE_ID)
                .unmarshal().json(JsonLibrary.Jackson, Transactions.class)
                // TODO 4: use process() method and call your processor
                .end();
    }
}