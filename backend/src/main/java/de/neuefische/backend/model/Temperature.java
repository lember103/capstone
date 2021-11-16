package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Temperature {
    @JsonProperty("Maximum")
    private Maximum maximum;
}
