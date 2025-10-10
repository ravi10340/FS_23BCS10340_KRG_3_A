package com.example.train.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.train.model.Train;
import com.example.train.service.TrainService;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService trainService;
    public TrainController(TrainService trainService){ this.trainService = trainService; }

    @GetMapping
    public ResponseEntity<List<Train>> all(){ return ResponseEntity.ok(trainService.getAllTrains()); }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String source, @RequestParam String destination){
        return ResponseEntity.ok(trainService.search(source, destination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return trainService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Map<String,Object> body){
        Train t = trainService.addTrain((String)body.getOrDefault("trainId", null),
                (String)body.get("name"), (String)body.get("source"), (String)body.get("destination"),
                (String)body.get("departure"), (String)body.get("arrival"),
                body.get("seats")==null? 0 : (Integer) body.get("seats"));
        return ResponseEntity.ok(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Map<String,Object> body){
        try{
            Train t = trainService.updateTrain(id, (String)body.get("name"), body.get("seats")==null? null : (Integer)body.get("seats"),
                    (String)body.get("departure"), (String)body.get("arrival"));
            return ResponseEntity.ok(t);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        trainService.deleteTrain(id);
        return ResponseEntity.ok(Map.of("message","Deleted"));
    }
}
