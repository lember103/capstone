package de.neuefische.backend.service;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.repo.TimerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TimerService {

    private final TimerRepo timerRepo;

    @Autowired
    public TimerService(TimerRepo timerRepo) {
        this.timerRepo = timerRepo;
    }

    public TimerModel getTimer() {
        Optional<TimerModel> optionalTimer = timerRepo.findFirstByOrderById();

        if (optionalTimer.isEmpty()){
            throw new IllegalStateException("No timer in database");
        } else {
            return optionalTimer.get();
        }
    }

    public TimerModel update(TimerModel timerModel) {
        timerRepo.deleteAll();
        return timerRepo.save(timerModel);
    }
}
