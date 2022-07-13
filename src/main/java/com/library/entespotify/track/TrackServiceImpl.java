package com.library.entespotify.track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private final TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
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
            .orElseThrow(() -> new TrackNotFoundException(id));
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
}
