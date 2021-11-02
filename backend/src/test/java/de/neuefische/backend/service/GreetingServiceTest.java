package de.neuefische.backend.service;

import de.neuefische.backend.model.Greeting;
import de.neuefische.backend.repo.GreetingRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GreetingServiceTest {

    GreetingRepo greetingRepo = mock(GreetingRepo.class);

    @Test
    void getGreeting() {
        //GIVEN
        String expected = "Hello World!";
        Greeting greeting = new Greeting(expected);

        when(greetingRepo.findAll()).thenReturn(List.of(greeting));

        //WHEN
        String actual = greetingRepo.findAll().get(0).getGreetingText();

        //THEN
        verify(greetingRepo).findAll();
        assertEquals(expected, actual);
    }
}