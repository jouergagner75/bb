package com.backbase.training.mapper;

import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionsPostRequestBody;
import com.backbase.training.beans.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

/**
 * @author Erkin Pehlivan
 * @since 13-03-2019
 **/

@Mapper
public interface TransactionMapper {

    TransactionMapper MAPPER = Mappers.getMapper(TransactionMapper.class);

    // TODO 7: map externalId to id
    @Mapping(target = "arrangementId", constant = "8a8a920a6bac6722016bac6e44dd0001")
    @Mapping(target = "externalArrangementId", constant = "A01")
    @Mapping(target = "reference", source = "thisAccount.number")
    @Mapping(target = "description", source = "details.description", defaultValue = "Gift")
    @Mapping(target = "typeGroup", constant = "Payment")
    @Mapping(target = "type", constant = "SEPA CT")
    @Mapping(target = "category", source = "thisAccount.kind")
    @Mapping(target = "bookingDate", dateFormat = "dd-MM-yyyy", source = "details.posted")
    @Mapping(target = "valueDate", dateFormat = "dd-MM-yyyy", source = "details.completed")
    @Mapping(target = "transactionAmountCurrency.amount", source = "details.newBalance.amount", qualifiedByName = "instructedAmountConverter", defaultValue = "0")
    @Mapping(target = "transactionAmountCurrency.currencyCode", constant = "EUR")
    @Mapping(target = "instructedAmountCurrency.amount", source = "details.value.amount")
    @Mapping(target = "instructedAmountCurrency.currencyCode", constant = "EUR")
    @Mapping(target = "currencyExchangeRate", defaultValue = "1")
    @Mapping(target = "counterPartyName", source = "thisAccount.kind")
    @Mapping(target = "counterPartyAccountNumber", source = "thisAccount.IBAN", qualifiedByName = "map", defaultValue = "NL86ABNA4461927814")
    @Mapping(target = "counterPartyBIC", source = "thisAccount.bank.nationalIdentifier", defaultValue = "ING00000001")
    @Mapping(target = "counterPartyCountry", constant = "NL")
    @Mapping(target = "counterPartyBankName", source = "thisAccount.bank.name")
    @Mapping(target = "creditorId", source = "otherAccount.holder.name")
    @Mapping(target = "mandateReference", source = "details.type")
    @Mapping(target = "billingStatus", defaultValue = "BILLED")
    @Mapping(target = "checkSerialNumber", defaultValue = "1")
    @Mapping(target = "runningBalance", defaultValue = "1")
    @Mapping(target = "creditDebitIndicator", source = "details.value.amount", qualifiedByName = "creditDebitIndicator")
    TransactionsPostRequestBody toTransactionsPostRequestBody(Transaction transaction);

    @Named("creditDebitIndicator")
    default TransactionsPostRequestBody.CreditDebitIndicator amountToCreditDebitIndicator(String amount) {
        BigDecimal value = new BigDecimal(amount);
        if (value.compareTo(BigDecimal.ZERO) < 0)
            return TransactionsPostRequestBody.CreditDebitIndicator.DBIT;
        return TransactionsPostRequestBody.CreditDebitIndicator.CRDT;
    }

    @Named("instructedAmountConverter")
    default BigDecimal convert(Object amount) {
        return new BigDecimal(amount.toString());
    }

    @Named("map")
    default String map(Object value) {
        return value.toString();
    }
}