package com.library.entespotify.services;

import com.library.entespotify.models.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> allArtists();

    Artist newArtist(Artist newArtist);

    Artist one(Long id);

    Artist replaceArtist(Artist newArtist, Long id);

    void deleteArtist(Long id);
}
