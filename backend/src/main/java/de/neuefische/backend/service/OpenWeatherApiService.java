package de.neuefische.backend.service;

import de.neuefische.backend.model.Days;
import de.neuefische.backend.model.WeatherForecast;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherApiService {

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/onecall?lat=52.50368426455495&lon=13.49911801532067&units=metric&exclude=current,minutely,hourly,alerts&appid=0a2b03a11f502524934b0f49801f64d3";
    private final RestTemplate restTemplate = new RestTemplate();

    public Days getWeatherForecastFromOpenWeather() {
        ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(API_URL, WeatherForecast.class);
        return response.getBody().getDaily().get(0);
    }


}
