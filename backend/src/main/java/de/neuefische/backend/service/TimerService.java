package de.neuefische.backend.service;

import de.neuefische.backend.model.TimerModel;
import de.neuefische.backend.repo.TimerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TimerService {

    private final TimerRepo timerRepo;

    @Autowired
    public TimerService(TimerRepo timerRepo) {
        this.timerRepo = timerRepo;
    }

    public TimerModel getTimer() {
        if (timerRepo.findAll().isEmpty()){
            throw new NoSuchElementException("No timer in database");
        } else {
            return timerRepo.findAll().get(0);
        }
    }

    public TimerModel update(TimerModel timerModel) {
        timerRepo.deleteAll();
        return timerRepo.save(timerModel);
    }
}
