package de.neuefische.backend.service;

import de.neuefische.backend.model.DailyForecasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherWidgetService {

    private final AccuWeatherApiService accuWeatherApiService;

    @Autowired
    public WeatherWidgetService(AccuWeatherApiService accuWeatherApiService){
        this.accuWeatherApiService = accuWeatherApiService;
    }

    public DailyForecasts getWeatherForecast(){
        return accuWeatherApiService.getWeatherForecastFromAccuWeather();
    }
}
