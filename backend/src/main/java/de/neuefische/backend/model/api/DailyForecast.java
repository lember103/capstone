package de.neuefische.backend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyForecast {

    private String id;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private Rain rain;
}
