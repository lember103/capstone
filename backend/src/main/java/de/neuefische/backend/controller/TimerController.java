package de.neuefische.backend.controller;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/timer")
public class TimerController {

    private final TimerService timerService;

    @Autowired
    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @GetMapping
    public PumpTimer getTimer(){
        return timerService.getTimer();
    }

    @PostMapping("/update")
    public PumpTimer updateTimer(@RequestBody PumpTimer pumpTimer){
        return timerService.update(pumpTimer);
    }
}
