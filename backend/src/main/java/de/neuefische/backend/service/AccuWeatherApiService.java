package de.neuefische.backend.service;

import de.neuefische.backend.model.DailyForecasts;
import de.neuefische.backend.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class AccuWeatherApiService {

    private final String apiURL;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public AccuWeatherApiService(@Value("${API_KEY}") String apiKEY) {
        this.apiURL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/178087?apikey="+apiKEY+"&details=true&metric=true";
    }

    public DailyForecasts getWeatherForecastFromAccuWeather() {
        ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(apiURL, WeatherForecast.class);
        return Objects.requireNonNull(response.getBody(), "There were no data received from OpenWeather").getDailyForecasts().get(0);
    }


}
