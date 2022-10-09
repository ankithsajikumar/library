package com.library.entespotify.services;

import com.library.entespotify.exceptions.EntityNotFoundException;
import com.library.entespotify.models.Album;
import com.library.entespotify.repositories.AlbumRepository;
import com.library.entespotify.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> allAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album newAlbum(Album newAlbum) {
        newAlbum.setCreatedBy(CommonUtils.getUser());
        return albumRepository.save(newAlbum);
    }

    @Override
    public Album one(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Album replaceAlbum(Album newAlbum, Long id) {
        return albumRepository.findById(id)
                .map(Album -> {
                    Album.setTitle(newAlbum.getTitle());
                    Album.setArtists(newAlbum.getArtists());
                    Album.setTracks(newAlbum.getTracks());
                    Album.setAlbumArt(newAlbum.getAlbumArt());
                    return albumRepository.save(Album);
                })
                .orElseGet(() -> {
                    newAlbum.setId(id);
                    return albumRepository.save(newAlbum);
                });
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
