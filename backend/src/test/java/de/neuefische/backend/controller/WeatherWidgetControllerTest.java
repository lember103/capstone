package de.neuefische.backend.controller;

import de.neuefische.backend.model.*;
import de.neuefische.backend.service.AccuWeatherApiService;
import de.neuefische.backend.service.WeatherWidgetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherWidgetControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final AccuWeatherApiService accuWeatherApiService = mock(AccuWeatherApiService.class);

    @Test
    void getWeatherForecast() {
        //GIVEN
        DailyForecasts expected = new DailyForecasts(
                "01.01.2000",
                new Temperature(
                        new Maximum(28,"C")
                ),
                new Day(
                        30,
                        new Rain(2, "mm")
                )
        );
        when(accuWeatherApiService.getWeatherForecastFromAccuWeather())
                .thenReturn(expected);

        //WHEN
        ResponseEntity<DailyForecasts> response = testRestTemplate.getForEntity(
                "/api/forecast", DailyForecasts.class);
        DailyForecasts actual = response.getBody();

        //THEN
        assertEquals(expected, actual);
        verify(accuWeatherApiService).getWeatherForecastFromAccuWeather();
    }
}