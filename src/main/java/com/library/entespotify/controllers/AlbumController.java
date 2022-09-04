package com.library.entespotify.controllers;

import com.library.entespotify.models.Album;
import com.library.entespotify.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    List<Album> all() {
        return albumService.allAlbums();
    }

    @PostMapping("/albums")
    Album newAlbum(@RequestBody Album newAlbum) {
        return albumService.newAlbum(newAlbum);
    }

    @GetMapping("/albums/{id}")
    Album one(@PathVariable Long id) {
        return albumService.one(id);
    }

    @PutMapping("/albums/{id}")
    Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable Long id) {
        return albumService.replaceAlbum(newAlbum, id);
    }

    @DeleteMapping("/albums/{id}")
    void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }
}
