package de.neuefische.backend.repo;

import de.neuefische.backend.model.PumpTimer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface TimerRepo extends PagingAndSortingRepository<PumpTimer, String> {

    List<PumpTimer> findAll();
    Optional<PumpTimer> findFirstByOrderById();
}
