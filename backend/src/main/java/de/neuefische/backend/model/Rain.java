package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rain {
    @JsonProperty("Value")
    private float value;
    @JsonProperty("Unit")
    private String unit;
}
