package de.neuefische.backend.controller;

import de.neuefische.backend.model.DailyForecasts;
import de.neuefische.backend.service.AccuWeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forecast")
public class AccuWeatherApiController {

    private final AccuWeatherApiService accuWeatherApiService;

    @Autowired
    public AccuWeatherApiController(AccuWeatherApiService accuWeatherApiService) {
        this.accuWeatherApiService = accuWeatherApiService;
    }

    @GetMapping
    public DailyForecasts getWeatherForecast(){
        return accuWeatherApiService.getWeatherForecastFromAccuWeather();
    }
}
