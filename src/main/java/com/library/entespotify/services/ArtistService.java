package com.library.entespotify.services;

import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistService {

    List<Artist> allArtists();

    Artist newArtist(Artist newArtist);

    Artist one(Long id);

    Artist replaceArtist(Artist newArtist, Long id);

    void deleteArtist(Long id);

    //Artist Albums...
    ResponseEntity<List<Album>> getAllAlbumsByArtistId(Long id);

    ResponseEntity<String> addAlbumToArtist(Long id, Long albumId);

    void deleteArtistAlbum(Long id, Long albumId);

    //Artist Tracks...
    ResponseEntity<List<Track>> getAllTracksByArtistId(Long artistId);

    ResponseEntity<String> addTrackToArtist(Long artistId, Long trackId);

    void deleteArtistTrack(Long artistId, Long trackId);
}
