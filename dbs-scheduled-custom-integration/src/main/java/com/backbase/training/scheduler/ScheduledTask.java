package com.backbase.training.scheduler;

import com.backbase.training.beans.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Erkin Pehlivan
 */
@Component
public class ScheduledTask {

    private final RestTemplate template;

    @Value("${openbankproject.transactions.url}")
    private String url;
    // TODO 3: Create a field with the type of PresentationTransactionTransactionsClient and add one more parameter to constructor to inject it


    @Autowired
    public ScheduledTask(RestTemplateBuilder builder) {
        this.template = builder.build();
    }

    // TODO 4: Use the right annotation to get transactions for every 2 hours
    public void createTransactions() {
        // TODO 8: call the relative method from client to add transactions to database
    }

    private List<TransactionsPostRequestBody> createData() {
        Transactions tx = null; // TODO 5: Get the transactions from open api

        return null; // TODO 6: Transform list of transactions to List<TransactionsPostRequestBody> using TransactionMapper interface and return it
    }

}