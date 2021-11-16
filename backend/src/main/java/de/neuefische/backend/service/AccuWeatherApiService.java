package de.neuefische.backend.service;

import de.neuefische.backend.model.DailyForecasts;
import de.neuefische.backend.model.WeatherForecast;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class AccuWeatherApiService {

    private static final String API_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/178087?apikey=xiXJGJfVofWBtkbSj51vTclQh0ognRyA&details=true&metric=true";
    private final RestTemplate restTemplate = new RestTemplate();

    public DailyForecasts getWeatherForecastFromAccuWeather() {
        ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(API_URL, WeatherForecast.class);
        return Objects.requireNonNull(response.getBody(), "There were no data received from OpenWeather").getDailyForecasts().get(0);
    }


}
