package de.neuefische.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PumpTimer {

    private float minutes;
    private String id;
    private boolean isDone;
}
