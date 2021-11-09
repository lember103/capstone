package de.neuefische.backend.controller;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.service.TimerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimerControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TimerService timerService;

    @Test
    void getTimer() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setMinutes(1);
        float expected = timer.getMinutes();

        timerService.update(timer);

        //WHEN
        ResponseEntity<PumpTimer> getResponse = testRestTemplate.getForEntity("/api/timer", PumpTimer.class);
        PumpTimer responseTimer = getResponse.getBody();
        assert responseTimer != null;
        float actual = responseTimer.getMinutes();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void updateTimer() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setMinutes(1);
        float expected = timer.getMinutes();

        //WHEN
        ResponseEntity<PumpTimer> postResponse = testRestTemplate.postForEntity("/api/timer", timer, PumpTimer.class);
        PumpTimer responseTimer = postResponse.getBody();
        assert responseTimer != null;
        float actual = responseTimer.getMinutes();

        //THEN
        assertEquals(expected, actual);
    }
}