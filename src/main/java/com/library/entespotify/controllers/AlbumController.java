package com.library.entespotify.controllers;

import com.library.entespotify.models.Album;
import com.library.entespotify.models.Track;
import com.library.entespotify.models.dto.AlbumInfo;
import com.library.entespotify.services.AlbumService;
import com.library.entespotify.services.DTOService;
import com.library.entespotify.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private final AlbumService albumService;

    @Autowired
    private final TrackService trackService;

    @Autowired
    private final DTOService dtoService;

    public AlbumController(AlbumService albumService, TrackService trackService, DTOService dtoService) {
        this.albumService = albumService;
        this.trackService = trackService;
        this.dtoService = dtoService;
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
    public void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }

    @PostMapping("/albums/{id}/track")
    public ResponseEntity<String> addTrackToAlbum(@PathVariable(value = "id") Long id, @RequestBody Long trackId) {
        return trackService.addTrackToAlbum(id, trackId);
    }

    @GetMapping("/albums/{id}/tracks")
    public ResponseEntity<List<Track>> getTracksOfAlbum(@PathVariable(value = "id") Long id) {
        return trackService.getTracksOfAlbum(id);
    }

    @GetMapping("/api/albums")
    ResponseEntity<List<AlbumInfo>> allAlbumApi() {
        return dtoService.getAllAlbumInfo();
    }

    @GetMapping("/api/albums/{id}")
    ResponseEntity<AlbumInfo> albumInfo(@PathVariable(value = "id") Long id) {
        return dtoService.getAlbumInfo(id);
    }
}
