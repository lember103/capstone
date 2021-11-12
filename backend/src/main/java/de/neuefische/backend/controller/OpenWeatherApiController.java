package de.neuefische.backend.controller;

import de.neuefische.backend.model.DailyForecast;
import de.neuefische.backend.service.OpenWeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forecast")
public class OpenWeatherApiController {

    private final OpenWeatherApiService openWeatherApiService;

    @Autowired
    public OpenWeatherApiController(OpenWeatherApiService openWeatherApiService) {
        this.openWeatherApiService = openWeatherApiService;
    }

    @GetMapping
    public DailyForecast getWeatherForecast(){
        return openWeatherApiService.getWeatherForecastFromOpenWeather();
    }
}
