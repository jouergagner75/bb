package com.backbase.peachtree.controller;

import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.buildingblocks.presentation.errors.ForbiddenException;
import com.backbase.buildingblocks.presentation.errors.InternalServerErrorException;
import com.backbase.buildingblocks.presentation.errors.NotFoundException;
import com.backbase.peachtree.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

/**
 * @author William Suane
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//TODO 7: Make this class implement the TransactionsApi from the OOTB transactions specification and make it a RestController
public class TransactionsController {
    private final TransactionsService transactionsService;

    //TODO 8: Provide the implementation for the method getTransactions and retrieve the transactions from the transactionsService

    @Override
    public void patchTransactions(@Valid List<TransactionsClientPatchRequestBody> list, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException, NotFoundException, ConflictException {
        httpServletResponse.setStatus(NOT_IMPLEMENTED.value());
    }

    @Override
    public void getTransactionsCsv(BigDecimal bigDecimal, BigDecimal bigDecimal1, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String[] strings, String s10, String s11, Integer integer, String s12, String s13, String s14, String[] strings1, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal[] bigDecimals, String s15, Integer integer1, String s16, Integer integer2, String s17, String s18, String s19, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException {
        httpServletResponse.setStatus(NOT_IMPLEMENTED.value());
    }

    @Override
    public void getTransactionsExport(BigDecimal bigDecimal, BigDecimal bigDecimal1, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String[] strings, String s10, String s11, Integer integer, String s12, String s13, String s14, String[] strings1, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal[] bigDecimals, String s15, Integer integer1, String s16, Integer integer2, String s17, String s18, String s19, String s20, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException {
        httpServletResponse.setStatus(NOT_IMPLEMENTED.value());
    }

    @Override
    public List<EnumValuesByAttributeNameGetResponseBody> getEnumValuesByAttributeName(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException, MethodNotAllowedException {
        httpServletResponse.setStatus(NOT_IMPLEMENTED.value());
        return emptyList();
    }
}