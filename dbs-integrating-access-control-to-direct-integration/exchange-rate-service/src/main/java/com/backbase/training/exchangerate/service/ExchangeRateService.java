package com.backbase.training.exchangerate.service;

import com.backbase.exchange.rate.rest.spec.v1.exchange.CurrenciesGetResponseBody;
import com.backbase.exchange.rate.rest.spec.v1.exchange.ExchangeRatesGetResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.MAX;
import static java.time.LocalTime.MIN;
import static org.springframework.http.HttpMethod.GET;

/**
 * @author William Suane
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExchangeRateService {

    private final RestTemplate restTemplate;
    @Value("${url.currency}")
    private String currencyURL;
    @Value("${url.rates}")
    private String ratesURL;
    @Value("${token}")
    private String token;

    //@formatter:off
    private ParameterizedTypeReference<List<CurrenciesGetResponseBody>> listCurrencyTypeReference = new ParameterizedTypeReference<List<CurrenciesGetResponseBody>>() {};
    private ParameterizedTypeReference<List<ExchangeRatesGetResponseBody>> listExchangeRatesTypeReference = new ParameterizedTypeReference<List<ExchangeRatesGetResponseBody>>() {};
    //@formatter:on

    public List<CurrenciesGetResponseBody> retrieveBalanceCurrencies() {
        return restTemplate.exchange(currencyURL, GET, authorizedHeader(), listCurrencyTypeReference).getBody();
    }

    public List<ExchangeRatesGetResponseBody> retrieveExchangeRates(String source, String target, Date from, Date to) {

        return restTemplate.exchange(ratesURL,
                GET,
                authorizedHeader(),
                listExchangeRatesTypeReference,
                source,
                target,
                dateToLocalDateTimeString(from, MIN),
                dateToLocalDateTimeString(to, MAX))
                .getBody();
    }

    private String dateToLocalDateTimeString(Date date, LocalTime time) {

        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .atTime(time)
                .toString();
    }

    private HttpEntity authorizedHeader() {
        HttpHeaders authorizedHeader = new HttpHeaders();
        authorizedHeader.add("Authorization", "Bearer " + token);
        return new HttpEntity(authorizedHeader);
    }
}