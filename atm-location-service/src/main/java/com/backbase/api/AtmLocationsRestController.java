package com.backbase.api;

import com.backbase.atm.location.rest.spec.v1.locations.Location;
import com.backbase.atm.location.rest.spec.v1.locations.LocationIdGetResponseBody;
import com.backbase.atm.location.rest.spec.v1.locations.LocationsApi;
import com.backbase.atm.location.rest.spec.v1.locations.LocationsGetResponseBody;
import com.backbase.beans.InlineResponse200ATM;
import com.backbase.beans.InlineResponse200Data;
import com.backbase.buildingblocks.presentation.errors.NotFoundException;
import com.backbase.mappers.LocationMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * @author Alejandro Aguirre
 **/
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AtmLocationsRestController implements LocationsApi {

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Value("${rest.locations.url}")
    private String locationsUrl;

    @Override
    @SneakyThrows
    public LocationsGetResponseBody getLocations(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        return new LocationsGetResponseBody().withLocations(parseLocationJson());
    }


    @Override
    @SneakyThrows
    public LocationIdGetResponseBody getLocationId(String locationId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Location location = parseLocationJson().stream().filter(l -> locationId.equals(l.getId())).findAny().orElseThrow(NotFoundException::new);
        return new LocationIdGetResponseBody().withId(location.getId()).withAddress(location.getAddress()).withCoordinates(location.getCoordinates()).withName(location.getName()).withType(location.getType());
    }

    private List<Location> parseLocationJson() throws JSONException, IOException {
        String json = executeRequest();
        // @formatter:off
        List<InlineResponse200Data> response = objectMapper.readValue(new JSONObject(json).getJSONArray("data").toString(), new TypeReference<List<InlineResponse200Data>>() {
        });
        // @formatter:on
        List<InlineResponse200ATM> atmList = !response.isEmpty() ? response.get(0).getBrand().get(0).getATM() : new ArrayList<>(1);
        return transformJsonToLocation(atmList);
    }

    private String executeRequest() throws IOException {
        try {
            return restTemplate.getForEntity(locationsUrl, String.class).getBody();
        } catch (Exception e) {
            log.info("Looks like the server is down, getting the JSON from the file");
            return new String(Files.readAllBytes(Paths.get("../extras/atms.json")));
        }
    }

    private List<Location> transformJsonToLocation(List<InlineResponse200ATM> atms) {
        return atms.stream().map(LocationMapper.INSTANCE::toLocation).collect(Collectors.toList());
    }
}