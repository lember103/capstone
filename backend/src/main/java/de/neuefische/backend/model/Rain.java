package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rain {
    @JsonProperty("Value")
    private float value;
    @JsonProperty("Unit")
    private String unit;
}
