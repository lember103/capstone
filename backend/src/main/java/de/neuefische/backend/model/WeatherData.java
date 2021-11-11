package de.neuefische.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherData {

    private Object temp;
    private int pop;

}
