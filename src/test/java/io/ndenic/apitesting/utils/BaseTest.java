package io.ndenic.apitesting.utils;

import java.util.HashMap;
import java.util.Map;

import io.ndenic.apitesting.service.APIService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest{

    public APIService manager;
    protected Map<String, String> endpoint = new HashMap<>();

    public BaseTest() {
        endpoint.put("login", "/example/login");
    }

    @BeforeClass(groups = {"regression", "smoke"})
    public void setup() {
        manager = new APIService();
        Map<String, String> headers = new HashMap<>();
        headers.put ("content-type", "application/json");
        headers.put ("Accept", "application/json");
        manager.setApiRequestContext(Helper.getApiUrl(), headers);
    }

    @AfterClass
    public void tearDown() {
        manager.disposeAPIRequestContext();
        manager.closePlaywright();
    }
}