package de.neuefische.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyForecast {

    @JsonProperty("temp")
    private Temp maxTemp;
    private float pop;
    private float rain;

    public float getMaxTemp() {
        return maxTemp.getMax();
    }
}
