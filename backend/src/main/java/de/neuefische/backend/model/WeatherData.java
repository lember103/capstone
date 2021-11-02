package de.neuefische.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private int temp;
    private int rainProb;
    private int relMoisture;
}
