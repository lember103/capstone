package de.neuefische.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PumpTimer {

    private String id;
    private boolean isDone;
    private boolean stopPump;
    private boolean isAutomatic;
    private int wakeUpTimerInSeconds;
    private float pumpRunTimeInMinutes;
}
