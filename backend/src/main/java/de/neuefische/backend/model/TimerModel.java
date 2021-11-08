package de.neuefische.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
public class TimerModel {

    private Duration duration;
    private String id;
}
