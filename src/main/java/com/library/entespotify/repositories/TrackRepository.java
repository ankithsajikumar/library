package com.library.entespotify.repositories;

import com.library.entespotify.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findTracksByArtistId(Long artistId);

    List<Track> findTracksByAlbumId(Long albumId);
}
