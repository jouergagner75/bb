package com.backbase.peachtree.mapper;

import com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionItem;
import com.mambu.sdk.model.v2.Client;
import com.mambu.sdk.model.v2.DepositAccount;
import com.mambu.sdk.model.v2.DepositTransaction;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.OffsetDateTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import static com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionItem.CreditDebitIndicator.CRDT;
import static com.backbase.presentation.transaction.rest.spec.v2.transactions.TransactionItem.CreditDebitIndicator.DBIT;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author William Suane
 **/
@Mapper
public interface TransactionMapper { //NOSONAR

    TransactionMapper MAPPER = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "id", source = "depositTransaction.encodedKey")
    @Mapping(target = "arrangementId", source = "depositTransaction.parentAccountKey")
    @Mapping(target = "bookingDate", dateFormat = "dd-MM-yyyy", source = "depositTransaction.creationDate", qualifiedByName = "fromThreeTenToDate")
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "notes", ignore = true)
    @Mapping(target = "type", source = "depositTransaction.type")
    @Mapping(target = "valueDate", dateFormat = "dd-MM-yyyy", source = "depositTransaction.valueDate", qualifiedByName = "fromThreeTenToDate")
    @Mapping(target = "transactionAmountCurrency.amount", source = "depositTransaction.amount")
    @Mapping(target = "transactionAmountCurrency.currencyCode", source = "depositTransaction.currencyCode")
    @Mapping(target = "currency", source = "depositTransaction.currencyCode")
    @Mapping(target = "creditDebitIndicator", source = "depositTransaction.amount", qualifiedByName = "creditDebitIndicatorUtil")
    @Mapping(target = "runningBalance", source = "depositTransaction.accountBalances.totalBalance")
    @Mapping(target = "counterPartyName", ignore = true)
    @Mapping(target = "counterPartyAccountNumber", source = "depositAccount.id")
    @Mapping(target = "counterPartyCountry", ignore = true)
    @Mapping(target = "reference", source = "depositTransaction.parentAccountKey")
    @Mapping(target = "typeGroup", source = "depositTransaction.type")
    @Mapping(target = "instructedAmount", source = "depositTransaction.amount")
    TransactionItem toTransactionsPostRequestBody(DepositTransaction depositTransaction, Client client, DepositAccount depositAccount);

    @Named("creditDebitIndicatorUtil")
    default TransactionItem.CreditDebitIndicator amountToCreditDebitIndicator(String amount) {
        return new BigDecimal(amount).compareTo(BigDecimal.ZERO) < 0 ? DBIT : CRDT;
    }

    @Named("fromThreeTenToDate")
    default Date fromThreeTenInstant(OffsetDateTime offsetDateTime) {
        return offsetDateTime == null ? null : DateTimeUtils.toDate(offsetDateTime.toInstant());
    }

    @BeforeMapping
    default void setCategories(@MappingTarget TransactionItem transactionItem) {
        String[] categories = {"Fast Food", "Public Transport", "Home", "Transfers", "Hobbies & Entertainment", "Shopping", "Other Income"};
        transactionItem.setCategory(categories[new Random().nextInt(categories.length)]);
    }

    @AfterMapping
    default void setCounterPartyName(@MappingTarget TransactionItem transactionItem, Client client) {
        transactionItem.setCounterPartyName(client.getFirstName() + " " + client.getLastName());
    }


    @AfterMapping
    default void setNotes(@MappingTarget TransactionItem transactionItem, DepositTransaction depositTransaction) {
        transactionItem.setDescription(depositTransaction.getNotes());
    }

    @AfterMapping
    default void setCountry(@MappingTarget TransactionItem transactionItem, Client client) {
        if (!isEmpty(client.getAddresses()))
            return;
        transactionItem.setCounterPartyName(client.getAddresses().get(0).getCountry());
    }
}