package io.ndenic.apitesting.utils;

import java.util.HashMap;
import java.util.Map;

import io.ndenic.apitesting.service.APIService;
import io.ndenic.apitesting.service.APIServiceException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest{

    protected APIService apiService;
    protected static final Map<String, String> ENDPOINT = new HashMap<>();
    private static final String CONTENT_TYPE_HEADER = "content-type";
    private static final String APPLICATION_JSON = "application/json";

    static {
        ENDPOINT.put("login", "/example/login");
    }

    @BeforeClass(groups = {"regression", "smoke"})
    public void setup() {
        apiService = new APIService();
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE_HEADER, APPLICATION_JSON);
        headers.put("Accept", APPLICATION_JSON);
        apiService.setApiRequestContext(Helper.getApiUrl(), headers);
    }

    @AfterClass
    public void tearDown() {
        try {
            apiService.disposeAPIRequestContext();
            apiService.closePlaywright();
        } catch (Exception e) {
            throw new APIServiceException("Error sending request: " + e.getMessage(), e);
        }
    }
}