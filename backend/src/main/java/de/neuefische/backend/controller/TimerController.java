package de.neuefische.backend.controller;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timer")
public class TimerController {

    private final TimerService timerService;

    @Autowired
    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @GetMapping
    public TimerModel getTimer(){
        return timerService.getTimer();
    }

    @PostMapping
    public TimerModel postTimer(@RequestBody TimerModel timerModel){
        System.out.println(timerModel);
        return timerModel;
    }
}
