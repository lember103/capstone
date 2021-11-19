package de.neuefische.backend.service;

import de.neuefische.backend.model.api.DailyForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherWidgetService {

    private final AccuWeatherApiService accuWeatherApiService;

    @Autowired
    public WeatherWidgetService(AccuWeatherApiService accuWeatherApiService){
        this.accuWeatherApiService = accuWeatherApiService;
    }

    public DailyForecast getWeatherForecast(){
        return accuWeatherApiService.getWeatherForecastFromAccuWeather();
    }
}
