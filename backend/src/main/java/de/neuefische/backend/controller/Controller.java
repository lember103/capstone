package de.neuefische.backend.controller;

import de.neuefische.backend.model.WeatherData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping
    public WeatherData getItem(){
        return new WeatherData(25, 30, 15);
    }
}
