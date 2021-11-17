package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyForecasts {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private Day day;
}
