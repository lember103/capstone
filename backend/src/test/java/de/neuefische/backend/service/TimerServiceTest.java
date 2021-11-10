package de.neuefische.backend.service;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.repo.TimerRepo;
import org.junit.jupiter.api.Test;

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
        PumpTimer timer = new PumpTimer();
        timer.setPumpRunTimeInMinutes(1);
        timer.setDone(false);
        timer.setStopPump(false);

        when(timerRepo.findFirstByOrderById()).thenReturn(Optional.of(timer));

        //WHEN
        PumpTimer actual = timerService.getTimer();

        //THEN
        assertEquals(timer, actual);
        verify(timerRepo, times(2)).findFirstByOrderById();
    }

    @Test
    void update() {
        //GIVEN
        PumpTimer timer = new PumpTimer();
        timer.setPumpRunTimeInMinutes(1);
        timer.setDone(false);
        timer.setStopPump(false);

        when(timerRepo.save(timer)).thenReturn(timer);

        //WHEN
        PumpTimer actual = timerService.update(timer);

        //THEN
        assertEquals(timer, actual);
        verify(timerRepo).save(timer);
    }
}