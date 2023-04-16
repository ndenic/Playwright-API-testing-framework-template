package io.ndenic.apitesting.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"nativeName","common","official"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {
    @JsonProperty("common")
    private String common;

    @JsonProperty("official")
    private String official;

    @JsonProperty("nativeName")
    private Map<String, Map<String, String>> nativeName;
}


