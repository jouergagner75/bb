package com.backbase.peachtree.mambu.config;

import com.mambu.sdk.api.ApiClient;
import com.mambu.sdk.api.Configuration;
import com.mambu.sdk.api.v2.ClientsApi;
import com.mambu.sdk.api.v2.DepositAccountsApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.backbase.peachtree.util.MambuAPIConstants.BASE_PATH;

/**
 * @author William Suane
 */
@Slf4j
@Component
public class MambuApiClientConfiguration {

    public static void setBasicTokenToConfiguration(ApiClient... apiClient) {
        // TODO 5: Add the Basic Authorization header to each apiClient.
    }

    private ApiClient apiClientConfiguredToBackbase() {
        log.info("Setting up configuration to access products from Mambu");
        Configuration.setDefaultApiClient(new ApiClient().setBasePath(BASE_PATH));
        Configuration.getDefaultApiClient().setReadTimeout(40000);
        Configuration.getDefaultApiClient().setWriteTimeout(40000);
        return Configuration.getDefaultApiClient();
    }

    @Bean
    public DepositAccountsApi depositAccountsApi() {
        return new DepositAccountsApi(apiClientConfiguredToBackbase());
    }

    @Bean
    public ClientsApi clientsApi() {
        return new ClientsApi(apiClientConfiguredToBackbase());
    }

    // TODO 4: Create a bean for the DepositTransactionsApi


}
