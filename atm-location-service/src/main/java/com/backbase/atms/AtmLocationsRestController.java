package com.backbase.atms;

import com.backbase.location.rest.spec.v1.locations.Location;
import com.backbase.location.rest.spec.v1.locations.LocationsApi;
import com.backbase.location.rest.spec.v1.locations.LocationsGetResponseBody;
import com.backbase.mappers.LocationMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openbankproject.api.model.InlineResponse200ATM;
import com.openbankproject.api.model.InlineResponse200Data;
import com.openbankproject.api.spec.ATMApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Erkin Pehlivan
 * @version 1.0
 * @since 16/05/2018
 *
 */
@RestController
public class AtmLocationsRestController implements LocationsApi {
    private final Logger LOGGER = LoggerFactory.getLogger(AtmLocationsRestController.class);
    private final ATMApi atmApi;

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public AtmLocationsRestController(ATMApi atmApi, ObjectMapper objectMapper,
                                      RestTemplateBuilder restTemplateBuilder) {
        this.atmApi = atmApi;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public LocationsGetResponseBody getLocations(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        try {
            return new LocationsGetResponseBody().withLocations(parseLocationJson());
        } catch (Exception e) {
            LOGGER.info("Error trying to get the locations", e);
        }
        return null;
    }

    private List<Location> parseLocationJson() throws JSONException, IOException {
        String json = executeRequest();
        // @formatter:off
        List<InlineResponse200Data> response = objectMapper.readValue(new JSONObject(json).getJSONArray("data").toString(),
                                                           new TypeReference<List<InlineResponse200Data>>() {});
        // @formatter:on
        List<InlineResponse200ATM> atmList = !response.isEmpty() ? response.get(0).getBrand().get(0).getATM() : new ArrayList<>(1);
        return transformJsonToLocation(atmList);
    }

    private String executeRequest() throws IOException {
        try {
            String url = atmApi.getApiClient().getBasePath() + "/atms";
            return restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            LOGGER.info("Looks like the server is down, getting the JSON from the file");
            return new String(Files.readAllBytes(Paths.get("../extras/atms.json")));
        }
    }

    private List<Location> transformJsonToLocation(List<InlineResponse200ATM> atms) {
        return atms.stream().map(LocationMapper.INSTANCE::toLocation).collect(Collectors.toList());
    }
}

