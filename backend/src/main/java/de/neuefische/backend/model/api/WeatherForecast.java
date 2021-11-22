package de.neuefische.backend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {

    @JsonProperty("DailyForecasts")
    private ArrayList<DailyForecast> dailyForecasts;
}
