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
       return timerRepo.findFirstByOrderById().orElseThrow(()-> new IllegalStateException("No timer in database")
    }

    public TimerModel update(TimerModel timerModel) {
        timerRepo.deleteAll();
        return timerRepo.save(timerModel);
    }
}
