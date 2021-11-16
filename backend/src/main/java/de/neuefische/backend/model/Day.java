package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Day {
    @JsonProperty("RainProbability")
    private int rainProbability;
    @JsonProperty("Rain")
    private Rain rain;
}
