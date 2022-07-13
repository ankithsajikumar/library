package com.library.entespotify.track;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackController {

    @Autowired
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    List<Track> all() {
        return trackService.allTracks();
    }

    @PostMapping("/tracks")
    Track newTrack(@RequestBody Track newTrack) {
        return trackService.newTrack(newTrack);
    }

    @GetMapping("/tracks/{id}")
    Track one(@PathVariable Long id) {
        return trackService.one(id);
    }

    @PutMapping("/tracks/{id}")
    Track replaceTrack(@RequestBody Track newTrack, @PathVariable Long id) {
        return trackService.replaceTrack(newTrack, id);
    }

    @DeleteMapping("/tracks/{id}")
    void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }
}
