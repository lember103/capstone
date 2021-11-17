package de.neuefische.backend.controller;

import de.neuefische.backend.model.*;
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
        when(testRestTemplate.getForEntity("/api/forecast", DailyForecasts.class))
                .thenReturn(ResponseEntity.ok(expected));

        //WHEN
        ResponseEntity<DailyForecasts> response = testRestTemplate.getForEntity(
                "/api/forecast", DailyForecasts.class);
        DailyForecasts actual = response.getBody();

        //THEN
        assertEquals(expected, actual);
        verify(testRestTemplate).getForEntity("/api/forecast", DailyForecasts.class);
    }
}