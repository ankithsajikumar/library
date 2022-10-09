package com.library.entespotify.services;

import com.library.entespotify.models.dto.AlbumInfo;
import com.library.entespotify.models.dto.ArtistInfo;
import com.library.entespotify.models.dto.TrackInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DTOService {

    ResponseEntity<List<TrackInfo>> getAllTrackInfo();

    ResponseEntity<List<AlbumInfo>> getAllAlbumInfo();

    ResponseEntity<List<ArtistInfo>> getAllArtistInfo();

    ResponseEntity<TrackInfo> getTrackInfo(Long id);

    ResponseEntity<AlbumInfo> getAlbumInfo(Long id);

    ResponseEntity<ArtistInfo> getArtistInfo(Long id);

}