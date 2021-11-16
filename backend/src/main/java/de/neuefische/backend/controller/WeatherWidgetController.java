package de.neuefische.backend.controller;

import de.neuefische.backend.model.DailyForecasts;
import de.neuefische.backend.service.AccuWeatherApiService;
import de.neuefische.backend.service.WeatherWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forecast")
public class WeatherWidgetController {

    private final WeatherWidgetService weatherWidgetService;

    @Autowired
    public WeatherWidgetController(WeatherWidgetService weatherWidgetService) {
        this.weatherWidgetService = weatherWidgetService;
    }

    @GetMapping
    public DailyForecasts getWeatherForecast(){
        return weatherWidgetService.getWeatherForecast();
    }
}
