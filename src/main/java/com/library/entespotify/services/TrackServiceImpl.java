package com.library.entespotify.services;

import com.library.entespotify.exceptions.EntityNotFoundException;
import com.library.entespotify.models.Album;
import com.library.entespotify.models.Track;
import com.library.entespotify.repositories.AlbumRepository;
import com.library.entespotify.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private final TrackRepository trackRepository;

    @Autowired
    private final AlbumRepository albumRepository;

    public TrackServiceImpl(TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Track> allTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track newTrack(Track newTrack) {
        return trackRepository.save(newTrack);
    }

    @Override
    public Track one(Long id) {
        return trackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Track replaceTrack(Track newTrack, Long id) {
        return trackRepository.findById(id)
                .map(Track -> {
                    Track.setTitle(newTrack.getTitle());
                    Track.setArtist(newTrack.getArtist());
                    Track.setAlbum(newTrack.getAlbum());
                    return trackRepository.save(Track);
                })
                .orElseGet(() -> {
                    newTrack.setId(id);
                    return trackRepository.save(newTrack);
                });
    }

    @Override
    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }

    //Track Album...
    @Override
    public ResponseEntity<String> addTrackToAlbum(Long albumId, Long trackId) {
        Track track = trackRepository.findById(trackId).orElseThrow(() -> new EntityNotFoundException(trackId));
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException(albumId));
        track.setAlbum(album);
        trackRepository.save(track);
        return new ResponseEntity<>("Track added to album", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Track>> getTracksOfAlbum(Long albumId) {
        if (albumRepository.existsById(albumId)) {
            List<Track> tracks = trackRepository.findTracksByAlbumId(albumId);
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
        throw new EntityNotFoundException(albumId);
    }
}
