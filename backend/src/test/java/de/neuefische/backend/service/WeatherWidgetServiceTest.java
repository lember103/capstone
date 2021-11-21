package de.neuefische.backend.service;

import de.neuefische.backend.model.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherWidgetServiceTest {

    private final AccuWeatherApiService accuWeatherApiService = mock(AccuWeatherApiService.class);
    private final WeatherWidgetService weatherWidgetService = new WeatherWidgetService(accuWeatherApiService);

    @Test
    void getWeatherForecast(){
        //GIVEN
        DailyForecast expected = new DailyForecast(
                "date",
                new Temperature(
                        new Maximum(10, "C")
                ),
                new Rain(30,
                        new Quantity(2, "mm")
                ));
        when(accuWeatherApiService.getWeatherForecastFromAccuWeather())
                .thenReturn(expected);
        //WHEN
        DailyForecast actual = weatherWidgetService.getWeatherForecast();

        //THEN
        assertEquals(expected, actual);
        verify(accuWeatherApiService).getWeatherForecastFromAccuWeather();
    }
}