package com.library.entespotify.services;

import com.library.entespotify.models.Track;

import java.util.List;

public interface TrackService {

    List<Track> allTracks();

    Track newTrack(Track newTrack);

    Track one(Long id);

    Track replaceTrack(Track newTrack, Long id);

    void deleteTrack(Long id);
}
