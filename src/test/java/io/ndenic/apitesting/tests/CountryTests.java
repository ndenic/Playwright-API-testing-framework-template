package io.ndenic.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.ndenic.apitesting.model.Country;
import io.ndenic.apitesting.utils.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class CountryTests extends BaseTest {

    public final String COUNTRY = "/germany";
    public final String COUNTRY_NATIVE_NAME = "србија";

    @SneakyThrows
    @Test(testName = "Test get country by name", groups = {"regression"})
    @Feature("Get country by name")
    public void getCountryByName() {
        APIResponse response = apiService.sendRequest("GET", ENDPOINT.get("getCountryByName") + COUNTRY);
        JSONArray jsonArray = new JSONArray(response.text());
        ObjectMapper mapper = new ObjectMapper();

        JSONObject nameObject = jsonArray.getJSONObject(0).getJSONObject("name");
        Country country = mapper.readValue(nameObject.toString(), Country.class);

        assertEquals(country.getCommon(), "Germany");
        assertEquals(country.getOfficial(), "Federal Republic of Germany");
    }

    @SneakyThrows
    @Test(testName = "Get non-existing country by name", groups = {"regression"})
    @Feature("Get non-existing country by its name")
    public void getNonExistingCountryByName() {
        APIResponse response = apiService.sendRequest("GET", ENDPOINT.get("getCountryByName") + "kos0vo");
        assertEquals(response.status(), HttpStatus.SC_NOT_FOUND);
    }

    @SneakyThrows
    @Test(testName = "Get country by native name", groups = {"regression"})
    @Feature("Get country by native name")
    public void getCountryByNativeName() {
        APIResponse response = apiService.sendRequest("GET", ENDPOINT.get("getCountryByName") + COUNTRY_NATIVE_NAME);
        JSONArray jsonArray = new JSONArray(response.text());
        ObjectMapper mapper = new ObjectMapper();

        JSONObject nameObject = jsonArray.getJSONObject(0).getJSONObject("name");
        Country country = mapper.readValue(nameObject.toString(), Country.class);

        assertEquals(country.getNativeName().get("srp").get("common"), "Србија");
    }

    @SneakyThrows
    @Test(testName = "Get country by full text", groups = {"regression"})
    @Feature("Get country by full text")
    public void getCountryByFullText() {
        APIResponse response =
                apiService.sendRequest("GET",
                        ENDPOINT.get("getCountryByName") + COUNTRY,
                        RequestOptions.create().setQueryParam("fullText", "true"));

        JSONArray jsonArray = new JSONArray(response.text());
        ObjectMapper mapper = new ObjectMapper();

        JSONObject nameObject = jsonArray.getJSONObject(0).getJSONObject("name");
        Country country = mapper.readValue(nameObject.toString(), Country.class);

        assertEquals(country.getCommon(), "Germany");
        assertEquals(country.getOfficial(), "Federal Republic of Germany");
    }
}
