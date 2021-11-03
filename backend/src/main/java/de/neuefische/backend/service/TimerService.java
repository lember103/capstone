package de.neuefische.backend.service;

import de.neuefische.backend.model.TimerModel;
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


    public TimerModel getTimer() {
        return timerRepo.findAll().get(0);
    }

    public TimerModel update(TimerModel timerModel) {
        timerRepo.deleteAll();
        return timerRepo.save(timerModel);
    }
}
