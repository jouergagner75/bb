package com.backbase.integration.transactions.processors;

import com.backbase.buildingblocks.backend.internalrequest.DefaultInternalRequestContext;
import com.backbase.buildingblocks.backend.internalrequest.InternalRequest;
import com.backbase.buildingblocks.backend.internalrequest.InternalRequestContext;
import com.backbase.integration.transactions.beans.Transaction;
import com.backbase.integration.transactions.beans.Transactions;
import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionsPostRequestBody;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


/**
 * @author Erkin Pehlivan
 * @since 17/07/2018
 */
@Component
public class PostTransactionsProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(PostTransactionsProcessor.class);

    // TODO 5: define and inject field with the type of PresentationTransactionTransactionsClient

    @Override
    // TODO 10: implement the fallback logic using @HystrixCommand annotation, in the fallback method, just log the body of the Exchange input message.
    public void process(Exchange exchange) {
        InternalRequest<List<TransactionsPostRequestBody>> internalRequest = new InternalRequest<>();
        internalRequest.setInternalRequestContext(createInternalRequestContext());
        internalRequest.setData(createData(exchange));
        // TODO 9: call the relative method from client to add transactions to database

    }

    private List<TransactionsPostRequestBody> createData(Exchange exchange) {
        Transactions body = null; // TODO 6: get body from exchange object
        List<Transaction> transactions = body.getTransactions();
        // TODO 7: use provided TransactionMapper interface to transform Transactions to TransactionsPostRequestBody and return list
        return null;
    }

    private InternalRequestContext createInternalRequestContext() {
        return new DefaultInternalRequestContext("", "", "", System.currentTimeMillis() / 1000L, "", "", UUID.randomUUID().toString());
    }
}