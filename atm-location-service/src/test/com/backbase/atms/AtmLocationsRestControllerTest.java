package com.backbase.atms;

import com.backbase.Application;
import com.backbase.location.rest.spec.v1.locations.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author William Suane on 18/09/2018
 */

@SpringBootTest(classes = Application.class)
@ActiveProfiles("it")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AtmLocationsRestControllerTest {

    @InjectMocks
    private AtmLocationsRestController atmLocationsRestController;

    static {
        System.setProperty("SIG_SECRET_KEY", "JWTSecretKeyDontUseInProduction!");
    }

    private static final String TEST_JWT =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxk"
                    + "ZXIiLCJpYXQiOjE0ODQ4MjAxOTYsImV4cCI6MTUxNjM1NjE5NiwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJv"
                    + "Y2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6IkpvaG5ueSIsIlN1cm5hbWUiOiJSb2NrZXQiLCJFbWFpbCI6Impyb2Nr"
                    + "ZXRAZXhhbXBsZS5jb20iLCJSb2xlIjpbIk1hbmFnZXIiLCJQcm9qZWN0IEFkbWluaXN0cmF0b3IiXSwiaW51aWQiOiJKaW1te"
                    + "SJ9.O9TE28ygrHmDjItYK6wRis6wELD5Wtpi6ekeYfR1WqM";

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturn401WhenAuthorizationHeaderIsNotSet() throws Exception {
        this.mockMvc
                .perform(get("/v1/locations"))
                .andDo(print())
                .andExpect(status().isUnauthorized());


    }

    @Test
    public void shouldMakeRequestAndContainTheJsonWithLocations() throws Exception {
        this.mockMvc
                .perform(get("/v1/locations")
                .header("Authorization", TEST_JWT))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("locations")));
    }

    @Test
    public void shouldParseTheJsonFromTheRequestToListOfLocations() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = get("/v1/locations")
                .header("Authorization", TEST_JWT);

        ResultActions result = mockMvc.perform(requestBuilder).andDo(print());

        result = result.andExpect(status().isOk());

        MvcResult response = result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        String responseBody = response.getResponse().getContentAsString();

        List<Location> locations = new ObjectMapper().readValue(new JSONObject(responseBody).getJSONArray("locations").toString(), new TypeReference<List<Location>>() {});

        assertNotNull(locations.get(0));

    }


}