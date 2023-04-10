package io.ndenic.apitesting.utils;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Helper {

    @SneakyThrows
    public static String generateStringFromResource(String path) {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    protected static Configuration config;

    static {
        String environment = System.getProperty("env", "dev"); // default to develop environment
        Configurations configs = new Configurations();
        try {
            config = configs.properties("src/main/resources/config." + environment + ".properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getApiUrl() {
        return config.getString("api.url");
    }

    public static String getApiUsername() {
        return config.getString("api.username");
    }

    public static String getApiPassword() {
        return config.getString("api.password");
    }
}
