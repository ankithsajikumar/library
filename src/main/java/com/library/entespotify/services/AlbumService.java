package com.library.entespotify.services;

import com.library.entespotify.models.Album;

import java.util.List;

public interface AlbumService {

    List<Album> allAlbums();

    Album newAlbum(Album newAlbum);

    Album one(Long id);

    Album replaceAlbum(Album newAlbum, Long id);

    void deleteAlbum(Long id);
}
