package de.neuefische.backend.controller;

import de.neuefische.backend.model.TimerModel;
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
        TimerModel timer = new TimerModel();
        timer.setDuration(Duration.ofMinutes(1));
        Duration expected = timer.getDuration();

        timerService.update(timer);

        //WHEN
        ResponseEntity<TimerModel> getResponse = testRestTemplate.getForEntity("/api/timer", TimerModel.class);
        TimerModel responseTimer = getResponse.getBody();
        assert responseTimer != null;
        Duration actual = responseTimer.getDuration();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void updateTimer() {
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setDuration(Duration.ofMinutes(1));
        Duration expected = timer.getDuration();

        //WHEN
        ResponseEntity<TimerModel> postResponse = testRestTemplate.postForEntity("/api/timer", timer, TimerModel.class);
        TimerModel responseTimer = postResponse.getBody();
        assert responseTimer != null;
        Duration actual = responseTimer.getDuration();

        //THEN
        assertEquals(expected, actual);
    }
}