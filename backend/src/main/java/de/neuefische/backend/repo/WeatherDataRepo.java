package de.neuefische.backend.repo;

import de.neuefische.backend.model.api.DailyForecast;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface WeatherDataRepo extends PagingAndSortingRepository<DailyForecast, String> {
    Optional<DailyForecast> findFirstByOrderById();
}
