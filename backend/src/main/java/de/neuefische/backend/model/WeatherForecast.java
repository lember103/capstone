package de.neuefische.backend.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherForecast {

    private List<DailyForecast> daily = new ArrayList<>();

}
