package com.library.entespotify.services;

import com.library.entespotify.models.Album;
import com.library.entespotify.models.Artist;
import com.library.entespotify.models.Track;
import com.library.entespotify.models.dto.AlbumDTO;
import com.library.entespotify.models.dto.ArtistDTO;
import com.library.entespotify.models.dto.TrackInfo;
import com.library.entespotify.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DTOService {
    @Autowired
    private TrackRepository trackRepository;

    public List<TrackInfo> getAllTrackInfo() {
        return trackRepository
                .findAll()
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    private TrackInfo convertDataIntoDTO(Track track) {

        TrackInfo dto = new TrackInfo();
        dto.setId(track.getId());
        dto.setTitle(track.getTitle());
        Album album = track.getAlbum();
        dto.setAlbum(convertAlbumDTO(album));
        Set<Artist> artists = track.getArtist();
        Set<ArtistDTO> artistDTOSet = artists.stream().map(this::convertArtistDTO).collect(Collectors.toSet());
        dto.setArtists(artistDTOSet);
        return dto;
    }

    private ArtistDTO convertArtistDTO(Artist artist) {

        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(artist.getId());
        artistDTO.setName(artist.getName());
        return artistDTO;
    }

    private AlbumDTO convertAlbumDTO(Album album) {

        if (album != null) {
            AlbumDTO albumDTO = new AlbumDTO();
            albumDTO.setId(album.getId());
            albumDTO.setTitle(album.getTitle());
            return albumDTO;
        }
        return null;
    }
}