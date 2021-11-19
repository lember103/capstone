package de.neuefische.backend.controller;

import de.neuefische.backend.model.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherWidgetControllerTest {

    @MockBean
    private TestRestTemplate testRestTemplate;

    @Test
    void getWeatherForecast() {
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
        when(testRestTemplate.getForEntity("/api/forecast", DailyForecast.class))
                .thenReturn(ResponseEntity.ok(expected));

        //WHEN
        ResponseEntity<DailyForecast> response = testRestTemplate.getForEntity(
                "/api/forecast", DailyForecast.class);
        DailyForecast actual = response.getBody();

        //THEN
        assertEquals(expected, actual);
        verify(testRestTemplate).getForEntity("/api/forecast", DailyForecast.class);
    }
}