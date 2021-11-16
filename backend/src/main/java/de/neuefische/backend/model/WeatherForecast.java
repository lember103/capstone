package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherForecast {

    @JsonProperty("DailyForecasts")
    private List<DailyForecasts> dailyForecasts = new ArrayList<>();

}
