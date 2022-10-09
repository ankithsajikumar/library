package com.library.entespotify.controllers;

import com.library.entespotify.models.Track;
import com.library.entespotify.models.dto.TrackInfo;
import com.library.entespotify.services.DTOService;
import com.library.entespotify.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {

    @Autowired
    private final TrackService trackService;

    @Autowired
    private final DTOService dtoService;

    public TrackController(TrackService trackService, DTOService dtoService) {
        this.trackService = trackService;
        this.dtoService = dtoService;
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
    public void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }

    @GetMapping("/api/tracks")
    List<TrackInfo> allTracks() {
        return dtoService.getAllTrackInfo();
    }

    @PostMapping("/tracks/{id}/album")
    public ResponseEntity<String> addTrackToAlbum(@PathVariable(value = "id") Long id, @RequestBody Long albumId) {
        return trackService.addTrackToAlbum(albumId, id);
    }
}
