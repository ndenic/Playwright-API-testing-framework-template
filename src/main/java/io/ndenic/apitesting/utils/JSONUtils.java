package io.ndenic.apitesting.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JSONUtils {
    // Parses a JSON string and returns a JsonObject
    public static JsonObject parseJsonString(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonString);
        if (element.isJsonObject()) {
            return element.getAsJsonObject();
        } else {
            throw new IllegalArgumentException("Invalid JSON string");
        }
    }

    // Parses a JSON file and returns a JsonObject
    public static JsonObject parseJsonFile(String filePath) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        return parseJsonString(jsonString);
    }

    // Serializes a Map to JSON and returns a string
    public static String serializeMapToJson(Map<String, Object> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
