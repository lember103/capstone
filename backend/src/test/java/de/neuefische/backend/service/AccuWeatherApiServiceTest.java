package de.neuefische.backend.service;

import de.neuefische.backend.model.api.*;
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
        DailyForecast expected = new DailyForecast(
                "01.01.2000",
                new Temperature(
                        new Maximum(28,"C")
                ),
                new Rain(
                        30,
                        new Quantity(2, "mm")
                )
        );
        when(accuWeatherApiService.getWeatherForecastFromAccuWeather())
                .thenReturn(expected);
        //WHEN
        DailyForecast actual = weatherWidgetService.getWeatherForecast();
        //THEN
        assertEquals(expected, actual);
    }
}

















