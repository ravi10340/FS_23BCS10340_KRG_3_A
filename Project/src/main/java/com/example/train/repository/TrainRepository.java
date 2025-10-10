package com.example.train.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.train.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findBySourceIgnoreCaseAndDestinationIgnoreCase(String source, String destination);
    boolean existsByTrainId(String trainId);
    Optional<Train> findByTrainId(String trainId);
}
