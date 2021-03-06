package de.neuefische.backend.service;

import de.neuefische.backend.model.api.DailyForecast;
import de.neuefische.backend.model.api.WeatherForecast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class AccuWeatherApiService {

    private final String apiURL;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public AccuWeatherApiService(@Value("${API_KEY}") String apiKEY) {
        this.apiURL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/178087?apikey="+apiKEY+"&details=true&metric=true";
    }

    public Optional<DailyForecast> getWeatherForecastFromAccuWeather() {
        try {
            ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(apiURL, WeatherForecast.class);
            return Optional.of(response.getBody().getDailyForecasts().get(0));
        } catch (Exception e){
            log.error(e.toString());
            return Optional.empty();
        }
    }
}
