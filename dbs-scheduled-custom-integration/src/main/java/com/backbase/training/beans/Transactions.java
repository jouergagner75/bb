package com.backbase.training.beans;

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
        return "Transactions{" +
                "transactions=" + transactions +
                '}';
    }
}