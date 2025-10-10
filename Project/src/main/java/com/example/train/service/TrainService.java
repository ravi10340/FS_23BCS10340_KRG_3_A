package com.example.train.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.train.model.Train;
import com.example.train.repository.TrainRepository;

@Service
public class TrainService {
    private final TrainRepository trainRepository;
    public TrainService(TrainRepository trainRepository){ this.trainRepository = trainRepository; }
    public long countTrains(){ return trainRepository.count(); }

    public Train addTrain(String trainId, String name, String source, String destination, String departure, String arrival, Integer seats) {
        if (trainId != null && trainRepository.existsByTrainId(trainId)) {
            throw new IllegalArgumentException("TrainId already exists");
        }
        Train t = new Train();
        t.setTrainId(trainId);
        t.setName(name);
        t.setSource(source);
        t.setDestination(destination);
        t.setDeparture(departure);
        t.setArrival(arrival);
        t.setSeats(seats);
        return trainRepository.save(t);
    }

    public List<Train> getAllTrains(){ return trainRepository.findAll(); }
    public Optional<Train> getById(Long id){ return trainRepository.findById(id); }
    public Train updateTrain(Long id, String name, Integer seats, String departure, String arrival){
        Train t = trainRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Train not found"));
        if(name!=null) t.setName(name);
        if(seats!=null) t.setSeats(seats);
        if(departure!=null) t.setDeparture(departure);
        if(arrival!=null) t.setArrival(arrival);
        return trainRepository.save(t);
    }
    public void deleteTrain(Long id){ trainRepository.deleteById(id); }
    public List<Train> search(String source, String destination){ return trainRepository.findBySourceIgnoreCaseAndDestinationIgnoreCase(source, destination); }
}
