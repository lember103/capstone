package de.neuefische.backend.model;

import lombok.Data;

@Data
public class Days {

    private Temp temp;
    private float pop;
    private float rain;

    public float getTemp() {
        return temp.getMax();
    }
}
