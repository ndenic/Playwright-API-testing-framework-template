package io.ndenic.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import io.ndenic.apitesting.utils.BaseTest;
import io.ndenic.apitesting.utils.Helper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import org.apache.http.HttpStatus;

import static org.testng.Assert.assertEquals;

public class AuthTests extends BaseTest {

    @Test(testName = "Test login as student", groups = {"regression"})
    @Feature("Authentication test")
    @Story("Test Auth API endpoint")
    public void authTestPost(){
        APIResponse response = apiService.sendRequest("POST", ENDPOINT.get("login"), RequestOptions.create().setData(""));
        assertEquals(response.status(), HttpStatus.SC_OK);
    }
}
