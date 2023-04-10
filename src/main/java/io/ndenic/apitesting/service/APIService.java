package io.ndenic.apitesting.service;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Map;

public class APIService {

    private final Playwright playwright;
    private APIRequestContext apiRequestContext;

    public APIService() {
        playwright = Playwright.create();
    }

    public void setApiRequestContext(String baseUrl, Map<String, String> headers) {
        apiRequestContext = playwright.request()
                .newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl)
                        .setExtraHTTPHeaders(headers));
    }

    public APIResponse sendRequest(String method, String endpoint, RequestOptions options) {
        APIResponse response = null;
        try {
            switch (method) {
                case "GET":
                    response = apiRequestContext.get(endpoint, options);
                    break;
                case "POST":
                    response = apiRequestContext.post(endpoint, options);
                    break;
                case "PUT":
                    response = apiRequestContext.put(endpoint, options);
                    break;
                case "PATCH":
                    response = apiRequestContext.patch(endpoint, options);
                    break;
                case "DELETE":
                    response = apiRequestContext.delete(endpoint, options);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid HTTP method");
            }
        } catch (Exception e) {
            throw new APIServiceException("Error sending request: " + e.getMessage(), e);
        }
        return response;
    }

    public APIResponse sendRequest(String method, String endpoint) {
        return sendRequest(method, endpoint, null);
    }

    public void disposeAPIRequestContext() {
        if (apiRequestContext != null) {
            apiRequestContext.dispose();
        }
    }

    public void closePlaywright() {
        if (playwright != null) {
            playwright.close();
        }
    }
}