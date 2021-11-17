package de.neuefische.backend.controller;

import de.neuefische.backend.model.DailyForecasts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherWidgetControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getWeatherForecast() {
        //GIVEN


        //WHEN
        ResponseEntity<DailyForecasts> response = testRestTemplate.getForEntity("/api/forecast", DailyForecasts.class);
        DailyForecasts actual = response.getBody();

        //THEN
    }
}