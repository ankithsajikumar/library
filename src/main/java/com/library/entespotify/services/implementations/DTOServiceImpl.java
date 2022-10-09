package com.library.entespotify.services.implementations;

import com.library.entespotify.exceptions.EntityNotFoundException;
import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import com.library.entespotify.models.dto.*;
import com.library.entespotify.repositories.AlbumRepository;
import com.library.entespotify.repositories.ArtistRepository;
import com.library.entespotify.repositories.TrackRepository;
import com.library.entespotify.services.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOServiceImpl implements DTOService {
    @Autowired
    private final TrackRepository trackRepository;

    @Autowired
    private final AlbumRepository albumRepository;

    @Autowired
    private final ArtistRepository artistRepository;

    public DTOServiceImpl(TrackRepository trackRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public ResponseEntity<List<TrackInfo>> getAllTrackInfo() {
        return
                new ResponseEntity<>(
                        trackRepository
                                .findAll()
                                .stream()
                                .map(this::convertTrackIntoTrackInfo)
                                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AlbumInfo>> getAllAlbumInfo() {
        return
                new ResponseEntity<>(
                        albumRepository
                                .findAll()
                                .stream()
                                .map(this::convertAlbumIntoAlbumInfo)
                                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ArtistInfo>> getAllArtistInfo() {
        return
                new ResponseEntity<>(
                        artistRepository
                                .findAll()
                                .stream()
                                .map(this::convertArtistIntoArtistInfo)
                                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TrackInfo> getTrackInfo(Long id) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return new ResponseEntity<>(convertTrackIntoTrackInfo(track), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AlbumInfo> getAlbumInfo(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return new ResponseEntity<>(convertAlbumIntoAlbumInfo(album), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArtistInfo> getArtistInfo(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return new ResponseEntity<>(convertArtistIntoArtistInfo(artist), HttpStatus.OK);
    }

    private TrackInfo convertTrackIntoTrackInfo(Track track) {

        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setId(track.getId());
        trackInfo.setTitle(track.getTitle());
        trackInfo.setAlbum(convertAlbumIntoDTO(track.getAlbum()));
        trackInfo.setArtists(track.getArtists().stream().map(this::convertArtistIntoDTO).collect(Collectors.toSet()));
        trackInfo.setAlbumArt(track.getAlbum() != null ? track.getAlbum().getAlbumArt() : null);
        trackInfo.setGenre(track.getGenre());
        return trackInfo;
    }

    private AlbumInfo convertAlbumIntoAlbumInfo(Album album) {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setId(album.getId());
        albumInfo.setTitle(album.getTitle());
        albumInfo.setTracks(album.getTracks().stream().map(this::convertTrackIntoDTO).collect(Collectors.toSet()));
        albumInfo.setArtists(album.getArtists().stream().map(this::convertArtistIntoDTO).collect(Collectors.toSet()));
        albumInfo.setAlbumArt(album.getAlbumArt());
        return albumInfo;
    }

    private ArtistInfo convertArtistIntoArtistInfo(Artist artist) {
        ArtistInfo artistInfo = new ArtistInfo();
        artistInfo.setId(artist.getId());
        artistInfo.setName(artist.getName());
        artistInfo.setTracks(artist.getTracks().stream().map(this::convertTrackIntoDTO).collect(Collectors.toSet()));
        artistInfo.setAlbums(artist.getAlbums().stream().map(this::convertAlbumIntoDTO).collect(Collectors.toSet()));
        artistInfo.setDisplayPicture(artist.getDisplayPicture());
        return artistInfo;
    }

    private ArtistDTO convertArtistIntoDTO(Artist artist) {
        if (artist != null) {
            ArtistDTO artistDTO = new ArtistDTO();
            artistDTO.setId(artist.getId());
            artistDTO.setName(artist.getName());
            return artistDTO;
        }
        return null;
    }

    private AlbumDTO convertAlbumIntoDTO(Album album) {
        if (album != null) {
            AlbumDTO albumDTO = new AlbumDTO();
            albumDTO.setId(album.getId());
            albumDTO.setTitle(album.getTitle());
            return albumDTO;
        }
        return null;
    }

    private TrackDTO convertTrackIntoDTO(Track track) {
        if (track != null) {
            TrackDTO trackDTO = new TrackDTO();
            trackDTO.setId(track.getId());
            trackDTO.setTitle(track.getTitle());
            return trackDTO;
        }
        return null;
    }
}