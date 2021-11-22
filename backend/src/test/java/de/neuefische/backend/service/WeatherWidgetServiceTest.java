package de.neuefische.backend.service;

import de.neuefische.backend.model.api.*;
import de.neuefische.backend.repo.WeatherDataRepo;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherWidgetServiceTest {

    private final AccuWeatherApiService accuWeatherApiService = mock(AccuWeatherApiService.class);
    private final WeatherDataRepo weatherDataRepo = mock(WeatherDataRepo.class);
    private final WeatherWidgetService weatherWidgetService = new WeatherWidgetService(accuWeatherApiService, weatherDataRepo);

    @Test
    void getWeatherForecast(){
        //GIVEN
        DailyForecast expected = new DailyForecast(
                "0",
                "date",
                new Temperature(
                        new Maximum(10, "C")
                ),
                new Rain(30,
                        new Quantity(2, "mm")
                ));
        when(accuWeatherApiService.getWeatherForecastFromAccuWeather())
                .thenReturn(Optional.of(expected));
        //WHEN
        DailyForecast actual = weatherWidgetService.getWeatherForecast();

        //THEN
        assertEquals(expected, actual);
        verify(accuWeatherApiService).getWeatherForecastFromAccuWeather();
    }
}