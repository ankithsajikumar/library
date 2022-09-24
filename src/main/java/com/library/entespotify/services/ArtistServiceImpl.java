package com.library.entespotify.services;

import com.library.entespotify.exceptions.EntityNotFoundException;
import com.library.entespotify.models.Artist;
import com.library.entespotify.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
}
