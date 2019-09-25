package com.backbase.integration.transactions.beans;

import java.util.List;

/**
 * @author Erkin Pehlivan
 * @since 17/07/2018
 */
public class Transactions {

    private List<Transaction> transactions = null;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transactions{");
        sb.append("transactions=").append(transactions);
        sb.append('}');
        return sb.toString();
    }
}