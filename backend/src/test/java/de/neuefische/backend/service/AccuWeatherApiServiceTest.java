package de.neuefische.backend.service;

import de.neuefische.backend.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccuWeatherApiServiceTest {

    @MockBean
    private AccuWeatherApiService accuWeatherApiService;

    @Autowired
    private WeatherWidgetService weatherWidgetService;

    @Test
    void getWeatherForecastFromAccuWeather() {
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
        DailyForecasts actual = weatherWidgetService.getWeatherForecast();
        //THEN
        assertEquals(expected, actual);
    }
}

















