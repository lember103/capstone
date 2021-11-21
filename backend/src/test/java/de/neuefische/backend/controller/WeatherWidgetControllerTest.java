package de.neuefische.backend.controller;

import de.neuefische.backend.model.api.*;
import de.neuefische.backend.security.model.AppUser;
import de.neuefische.backend.security.repo.AppUserRepo;
import de.neuefische.backend.service.AccuWeatherApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherWidgetControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private AccuWeatherApiService accuWeatherApiService;

    private HttpHeaders getHttpHeadersWithJWT() {
        userRepo.save(AppUser.builder().username("test_username").password(passwordEncoder.encode("some-password")).build());
        AppUser loginData = new AppUser("test_username", "some-password");
        ResponseEntity<String> response = testRestTemplate.postForEntity("/auth/login", loginData, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Objects.requireNonNull(response.getBody()));
        return headers;
    }

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
        ResponseEntity<DailyForecast> response = testRestTemplate.exchange(
                "/api/forecast",
                HttpMethod.GET,
                new HttpEntity<DailyForecast>(getHttpHeadersWithJWT()),
                DailyForecast.class);
        DailyForecast actual = response.getBody();

        //THEN
        assertEquals(expected, actual);
        verify(accuWeatherApiService).getWeatherForecastFromAccuWeather();
    }
}