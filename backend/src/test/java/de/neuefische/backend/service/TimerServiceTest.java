package de.neuefische.backend.service;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.repo.TimerRepo;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void getTimer(){
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setMinutes(1);
        float expected = timer.getMinutes();

        when(timerRepo.findFirstByOrderById()).thenReturn(Optional.of(timer));

        //WHEN
        float actual = timerService.getTimer().getMinutes();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).findFirstByOrderById();
    }

    @Test
    void update() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setMinutes(1);
        float expected = timer.getMinutes();

        when(timerRepo.save(timer)).thenReturn(timer);

        //WHEN
        float actual = timerService.update(timer).getMinutes();

        //THEN
        assertEquals(expected, actual);
        verify(timerRepo).save(timer);
    }
}