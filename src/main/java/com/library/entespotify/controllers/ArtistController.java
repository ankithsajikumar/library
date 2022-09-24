package com.library.entespotify.controllers;

import com.library.entespotify.models.Artist;
import com.library.entespotify.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
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
    void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }
}
