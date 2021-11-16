package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Maximum {
    @JsonProperty("Value")
    private float value;
    @JsonProperty("Unit")
    private String unit;
}
