package de.neuefische.backend.controller;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.repo.TimerRepo;
import de.neuefische.backend.service.TimerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimerControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TimerService timerService;

    @Autowired
    private TimerRepo timerRepo;

    @Test
    void getTimer() {
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setTimerDuration("1");
        String expected = timer.getTimerDuration();

        timerService.update(timer);

        //WHEN
        ResponseEntity<TimerModel> getResponse = testRestTemplate.getForEntity("/api/timer", TimerModel.class);
        TimerModel responseTimer = getResponse.getBody();
        assert responseTimer != null;
        String actual = responseTimer.getTimerDuration();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void updateTimer() {
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setTimerDuration("2");
        String expected = timer.getTimerDuration();

        //WHEN
        ResponseEntity<TimerModel> postResponse = testRestTemplate.postForEntity("/api/timer", timer, TimerModel.class);
        TimerModel responseTimer = postResponse.getBody();
        assert responseTimer != null;
        String actual = responseTimer.getTimerDuration();

        //THEN
        assertEquals(expected, actual);
    }
}