package de.neuefische.backend.service;

import de.neuefische.backend.model.PumpTimer;
import de.neuefische.backend.repo.TimerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return pumpTimer;
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
}
