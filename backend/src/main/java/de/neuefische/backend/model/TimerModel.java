package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimerModel {

    @JsonProperty("timerDuration")
    private String timerDuration;
    private String id;
}
