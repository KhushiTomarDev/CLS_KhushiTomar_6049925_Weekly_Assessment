package com.example.Assessment2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assessment2.entity.Track;
import com.example.Assessment2.repo.TrackRepository;
import java.util.*;
//import java.util.Map;


@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackRepository iTrackRepo;

    
    @PostMapping("/tracks")
    public ResponseEntity<String> addTrack(@RequestBody Track track) {

        iTrackRepo.save(track);
        return ResponseEntity.ok("Track added successfully");
    }

    
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks() {

        List<Track> list = iTrackRepo.findAll();

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(list);
    }

    
    @GetMapping("/tracks/Bytitle")
    public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam("title") String track_title) {

        List<Track> list = iTrackRepo.findByTitle(track_title);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(list);
    }

   
    @GetMapping("/tracks/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Integer id) {

        Optional<Track> track = iTrackRepo.findById(id);

        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404).body("Track not found");
        }
    }
    }



