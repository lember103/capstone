package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    @JsonProperty("RainProbability")
    private int rainProbability;
    @JsonProperty("Rain")
    private Rain rain;
}
