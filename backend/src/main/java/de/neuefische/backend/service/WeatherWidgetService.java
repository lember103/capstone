package de.neuefische.backend.service;

import de.neuefische.backend.model.api.DailyForecast;
import de.neuefische.backend.repo.TimerRepo;
import de.neuefische.backend.repo.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherWidgetService {

    private final AccuWeatherApiService accuWeatherApiService;
    private final WeatherDataRepo weatherDataRepo;

    @Autowired
    public WeatherWidgetService(AccuWeatherApiService accuWeatherApiService, WeatherDataRepo weatherDataRepo){
        this.accuWeatherApiService = accuWeatherApiService;
        this.weatherDataRepo = weatherDataRepo;
    }

    public DailyForecast getWeatherForecast(){
        Optional<DailyForecast> dailyForecast = accuWeatherApiService.getWeatherForecastFromAccuWeather();
        if (dailyForecast.isPresent()){
            weatherDataRepo.deleteAll();
            return weatherDataRepo.save(dailyForecast.get());
        } else return weatherDataRepo.findFirstByOrderById().orElseThrow(
                () -> new IllegalStateException("No weather data in database"));
    }
}












