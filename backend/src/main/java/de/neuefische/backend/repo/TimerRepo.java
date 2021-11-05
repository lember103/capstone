package de.neuefische.backend.repo;

import de.neuefische.backend.model.TimerModel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface TimerRepo extends PagingAndSortingRepository<TimerModel, String> {

    List<TimerModel> findAll();
    Optional<TimerModel> findFirstByOrderById();
}