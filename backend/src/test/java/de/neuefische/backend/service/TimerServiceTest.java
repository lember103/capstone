package de.neuefische.backend.service;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.repo.TimerRepo;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TimerServiceTest {

    private final TimerRepo timerRepo = mock(TimerRepo.class);
    private final TimerService timerService = new TimerService(timerRepo);

    @Test
    void getTimerThrowsIllegalStateException() {
        //GIVEN
        when(timerRepo.findFirstByOrderById()).thenReturn(Optional.empty());

        //WHEN
        //THEN
        assertThrows(IllegalStateException.class, timerService::getTimer);
        verify(timerRepo).findFirstByOrderById();
    }

    @Test
    void getTimer(){
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setDuration(Duration.ofMinutes(1));
        Duration expected = timer.getDuration();

        when(timerRepo.findFirstByOrderById()).thenReturn(Optional.of(timer));

        //WHEN
        Duration actual = timerService.getTimer().getDuration();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).findFirstByOrderById();
    }

    @Test
    void update() {
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setDuration(Duration.ofMinutes(1));
        Duration expected = timer.getDuration();

        when(timerRepo.save(timer)).thenReturn(timer);

        //WHEN
        Duration actual = timerService.update(timer).getDuration();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).save(timer);
    }
}