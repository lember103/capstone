package de.neuefische.backend.service;

import de.neuefische.backend.repo.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepo greetingRepo;

    @Autowired
    public GreetingService(GreetingRepo greetingRepo) {
        this.greetingRepo = greetingRepo;
    }

    public String getGreeting() {
        return greetingRepo.findAll().get(0).getGreetingText();
    }
}
