package com.backbase.integration.transactions.mapper;

import com.backbase.integration.transactions.beans.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Erkin Pehlivan
 * @since 13-03-2019
 **/

@Mapper
public interface TransactionMapper {

    TransactionMapper MAPPER = Mappers.getMapper(TransactionMapper.class);

    // TODO 8: import TransactionsPostRequestBody
    TransactionsPostRequestBody toPresentation(Transaction tx);

}