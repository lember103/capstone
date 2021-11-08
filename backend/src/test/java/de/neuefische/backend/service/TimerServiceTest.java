package de.neuefische.backend.service;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.repo.TimerRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
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
        timer.setTimerDuration("1");
        String expected = timer.getTimerDuration();

        when(timerRepo.findFirstByOrderById()).thenReturn(Optional.of(timer));

        //WHEN
        String actual = timerService.getTimer().getTimerDuration();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).findFirstByOrderById();
    }

    @Test
    void update() {
        //GIVEN
        TimerModel timer = new TimerModel();
        timer.setTimerDuration("1");
        String expected = timer.getTimerDuration();

        when(timerRepo.save(timer)).thenReturn(timer);

        //WHEN
        String actual = timerService.update(timer).getTimerDuration();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).save(timer);
    }
}