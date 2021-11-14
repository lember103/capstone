package de.neuefische.backend.service;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.repo.TimerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimerService {

    private final TimerRepo timerRepo;

    @Autowired
    public TimerService(TimerRepo timerRepo) {
        this.timerRepo = timerRepo;
    }

    public PumpTimer getTimer() {
        PumpTimer pumpTimer = getTimerFromRepo();
        if (!pumpTimer.isDone()){
            setPumpTimerAsDone();
        }
        if (pumpTimer.isAutomatic()){
            pumpTimer.setWakeUpTimerInSeconds(setWakeUpTimer());
        }
        return pumpTimer;
    }

    private int setWakeUpTimer() {
        int currentHour = getCurrentTime().getHour();
        if (currentHour < 4){
            return (4 - currentHour) * 3600;
        }
        else if (currentHour >= 4 && currentHour < 16){
            return (16 - currentHour) * 3600;
        }
        else if (currentHour >= 16){
            return ((24 - currentHour) + 4 ) * 3600;
        }
        else return -1;
    }

    private void setPumpTimerAsDone() {
        PumpTimer pumpTimer = getTimerFromRepo();
        pumpTimer.setDone(true);
        timerRepo.deleteAll();
        timerRepo.save(pumpTimer);
    }

    private PumpTimer getTimerFromRepo() {
        return timerRepo.findFirstByOrderById().orElseThrow(
                () -> new IllegalStateException("No timer in database"));
    }

    public PumpTimer update(PumpTimer pumpTimer) {
        timerRepo.deleteAll();
        return timerRepo.save(pumpTimer);
    }

    public ZonedDateTime getCurrentTime(){
        return ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
    }
}
