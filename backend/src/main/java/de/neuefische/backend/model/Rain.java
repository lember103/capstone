package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rain {
    @JsonProperty("Value")
    private float value;
    @JsonProperty("Unit")
    private String unit;
}
