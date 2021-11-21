package de.neuefische.backend.controller;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.security.model.AppUser;
import de.neuefische.backend.security.repo.AppUserRepo;
import de.neuefische.backend.service.TimerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimerControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TimerService timerService;

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private HttpHeaders getHttpHeadersWithJWT() {
        userRepo.save(AppUser.builder().username("test_username").password(passwordEncoder.encode("some-password")).build());
        AppUser loginData = new AppUser("test_username", "some-password");
        ResponseEntity<String> response = testRestTemplate.postForEntity("/auth/login", loginData, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Objects.requireNonNull(response.getBody()));
        return headers;
    }

    @Test
    void getTimer() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setPumpRunTimeInMinutes(1);
        timer.setDone(false);
        timer.setStopPump(false);

        timerService.update(timer);

        //WHEN
        ResponseEntity<PumpTimer> getResponse = testRestTemplate.exchange(
                "/api/timer",
                HttpMethod.GET,
                new HttpEntity<>(getHttpHeadersWithJWT()),
                PumpTimer.class
        );
        PumpTimer actual = getResponse.getBody();

        //THEN
        assertEquals(timer, actual);
    }

    @Test
    void updateTimer() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setPumpRunTimeInMinutes(1);
        timer.setDone(false);
        timer.setStopPump(false);

        //WHEN
        ResponseEntity<PumpTimer> postResponse = testRestTemplate.exchange(
                "/api/timer",
                HttpMethod.POST,
                new HttpEntity<>(timer, getHttpHeadersWithJWT()),
                PumpTimer.class);
        PumpTimer actual = postResponse.getBody();
        assert actual != null;
        timer.setId(actual.getId());

        //THEN
        assertEquals(timer, actual);
    }
}