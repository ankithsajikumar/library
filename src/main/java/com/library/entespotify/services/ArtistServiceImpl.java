package com.library.entespotify.services;

import com.library.entespotify.exceptions.EntityNotFoundException;
import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import com.library.entespotify.repositories.AlbumRepository;
import com.library.entespotify.repositories.ArtistRepository;
import com.library.entespotify.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private final ArtistRepository artistRepository;

    @Autowired
    private final AlbumRepository albumRepository;

    @Autowired
    private final TrackRepository trackRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository, AlbumRepository albumRepository, TrackRepository trackRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Artist> allArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist newArtist(Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    @Override
    public Artist one(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Artist replaceArtist(Artist newArtist, Long id) {
        return artistRepository.findById(id)
                .map(Artist -> {
                    Artist.setName(newArtist.getName());
                    Artist.setAlbums(newArtist.getAlbums());
                    Artist.setTracks(newArtist.getTracks());
                    return artistRepository.save(Artist);
                })
                .orElseGet(() -> {
                    newArtist.setId(id);
                    return artistRepository.save(newArtist);
                });
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    //Artist Albums...
    @Override
    public ResponseEntity<List<Album>> getAllAlbumsByArtistId(Long id) {
        if (artistRepository.existsById(id)) {
            List<Album> albums = albumRepository.findAlbumsByArtistsId(id);
            return new ResponseEntity<>(albums, HttpStatus.OK);
        }
        throw new EntityNotFoundException(id);
    }

    @Override
    public ResponseEntity<String> addAlbumToArtist(Long id, Long albumId) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException(albumId));
        artist.setAlbum(album);
        artistRepository.save(artist);
        return new ResponseEntity<>("added album to artist", HttpStatus.CREATED);
    }

    @Override
    public void deleteArtistAlbum(Long id, Long albumId) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Album delAlbum = artist.getAlbums().stream().filter(album -> album.getId().equals(albumId)).findFirst().orElseThrow(() -> new EntityNotFoundException(albumId));
        artist.deleteAlbum(delAlbum);
        artistRepository.save(artist);
    }

    // Artist tracks...
    @Override
    public ResponseEntity<List<Track>> getAllTracksByArtistId(Long id) {
        if (artistRepository.existsById(id)) {
            List<Track> tracks = trackRepository.findTracksByArtistId(id);
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }
        throw new EntityNotFoundException(id);
    }

    @Override
    public ResponseEntity<String> addTrackToArtist(Long id, Long trackId) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Track track = trackRepository.findById(trackId).orElseThrow(() -> new EntityNotFoundException(trackId));
        artist.setTrack(track);
        artistRepository.save(artist);
        return new ResponseEntity<>("Track added to artist", HttpStatus.CREATED);
    }

    @Override
    public void deleteArtistTrack(Long id, Long trackId) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Track delTrack = trackRepository.findById(trackId).stream().filter(track -> track.getId().equals(trackId)).findFirst().orElseThrow(() -> new EntityNotFoundException(trackId));
        artist.deleteTrack(delTrack);
        artistRepository.save(artist);
    }
}
