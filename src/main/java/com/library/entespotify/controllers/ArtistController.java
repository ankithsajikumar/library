package com.library.entespotify.controllers;

import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import com.library.entespotify.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    List<Artist> all() {
        return artistService.allArtists();
    }

    @PostMapping("/artists")
    Artist newArtist(@RequestBody Artist newArtist) {
        return artistService.newArtist(newArtist);
    }

    @GetMapping("/artists/{id}")
    Artist one(@PathVariable Long id) {
        return artistService.one(id);
    }

    @PutMapping("/artists/{id}")
    Artist replaceArtist(@RequestBody Artist newArtist, @PathVariable Long id) {
        return artistService.replaceArtist(newArtist, id);
    }

    @DeleteMapping("/artists/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }

    @GetMapping("/artists/{id}/albums")
    public ResponseEntity<List<Album>> getAllAlbumsByArtistId(@PathVariable(value = "id") Long id) {
        return artistService.getAllAlbumsByArtistId(id);
    }

    @PostMapping("/artists/{id}/album")
    public ResponseEntity<String> addAlbumToArtist(@PathVariable(value = "id") Long id, @RequestBody Long trackId) {
        return artistService.addAlbumToArtist(id, trackId);
    }

    @DeleteMapping("/artists/{id}/album/{albumId}")
    public void deleteArtistAlbum(@PathVariable(value = "id") Long id, @PathVariable(value = "albumId") Long albumId) {
        artistService.deleteArtistAlbum(id, albumId);
    }

    @GetMapping("/artists/{id}/tracks")
    public ResponseEntity<List<Track>> getAllTracksByArtistId(@PathVariable(value = "id") Long id) {
        return artistService.getAllTracksByArtistId(id);
    }

    @PostMapping("/artists/{id}/track")
    public ResponseEntity<String> addTrackToArtist(@PathVariable(value = "id") Long id, @RequestBody Long trackId) {
        return artistService.addTrackToArtist(id, trackId);
    }

    @DeleteMapping("/artists/{id}/track/{trackId}")
    public void deleteArtistTrack(@PathVariable(value = "id") Long id, @PathVariable(value = "trackId") Long trackId) {
        artistService.deleteArtistTrack(id, trackId);
    }
}
