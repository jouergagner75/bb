package com.backbase.integration.transactions.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erkin Pehlivan
 * @since 17/07/2018
 */
public class Transaction {
    private String externalId;
    private String externalArrangementId;
    private String reference;
    private String description;

    /**
     * P = Payment, W = Withdraw, L = Loans, F = Fees
     */
    private String typeGroup;

    /**
     * SEPA_CT, SEPA_DD, BACS_UK, FASTER_PAYMENT_UK, CHAPS_UK, INTERNATIONAL_PAYMENT, LOAN_REDEMPTION, INTEREST_SETTLEMENT
     */
    private String type;
    private String category;
    private Date bookingDate;
    private Date valueDate;
    private BigDecimal amount;

    /**
     * USD, EUR
     */
    private String currency;

    /**
     * C = CREDIT, D = DEBIT
     */
    private String creditDebitIndicator;
    private BigDecimal instructedAmount;
    private String instructedCurrency;
    private BigDecimal currencyExchangeRate;
    private String counterPartyName;
    private String counterPartyAccountNumber;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalArrangementId() {
        return externalArrangementId;
    }

    public void setExternalArrangementId(String externalArrangementId) {
        this.externalArrangementId = externalArrangementId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public BigDecimal getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(BigDecimal instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public String getInstructedCurrency() {
        return instructedCurrency;
    }

    public void setInstructedCurrency(String instructedCurrency) {
        this.instructedCurrency = instructedCurrency;
    }

    public BigDecimal getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(BigDecimal currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public void setCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
    }

    public String getCounterPartyAccountNumber() {
        return counterPartyAccountNumber;
    }

    public void setCounterPartyAccountNumber(String counterPartyAccountNumber) {
        this.counterPartyAccountNumber = counterPartyAccountNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("externalId='").append(externalId).append('\'');
        sb.append(", externalArrangementId='").append(externalArrangementId).append('\'');
        sb.append(", reference='").append(reference).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", typeGroup='").append(typeGroup).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", bookingDate=").append(bookingDate);
        sb.append(", valueDate=").append(valueDate);
        sb.append(", amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", creditDebitIndicator='").append(creditDebitIndicator).append('\'');
        sb.append(", instructedAmount=").append(instructedAmount);
        sb.append(", instructedCurrency='").append(instructedCurrency).append('\'');
        sb.append(", currencyExchangeRate=").append(currencyExchangeRate);
        sb.append(", counterPartyName='").append(counterPartyName).append('\'');
        sb.append(", counterPartyAccountNumber='").append(counterPartyAccountNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}