package com.backbase.training.exchangerate.controller;

import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.buildingblocks.presentation.errors.ForbiddenException;
import com.backbase.buildingblocks.presentation.errors.InternalServerErrorException;
import com.backbase.exchange.rate.rest.spec.v1.exchange.CurrenciesGetResponseBody;
import com.backbase.exchange.rate.rest.spec.v1.exchange.ExchangeApi;
import com.backbase.exchange.rate.rest.spec.v1.exchange.ExchangeRatesGetResponseBody;
import com.backbase.training.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author William Suane
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class ExchangeRateController implements ExchangeApi {

    private final ExchangeRateService exchangeRateService;

    /**
     * Get list of currencies that your can hold in your borderless account
     * <p>
     * http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies
     */
    @Override
    public List<CurrenciesGetResponseBody> getCurrencies(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException {
        return exchangeRateService.retrieveBalanceCurrencies();
    }

    /**
     * Fetch latest exchange rates of all currencies if you don't send params
     * Fetch exchange rate history over period of time with daily interval with params
     * <p>
     * http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates
     * http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates?from=2019-06-21&to=2019-06-21&group=day
     */
    @Override
    public List<ExchangeRatesGetResponseBody> getExchangeRates(String source, String target, Date from, Date to, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, ForbiddenException, InternalServerErrorException {
        return exchangeRateService.retrieveExchangeRates(source, target, ObjectUtils.defaultIfNull(from, new Date()), ObjectUtils.defaultIfNull(to, new Date()));
    }


}