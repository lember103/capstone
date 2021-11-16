package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Day {
    @JsonProperty("RainProbability")
    private int rainProbability;
    @JsonProperty("Rain")
    private Rain rain;
}
