package com.library.entespotify.repositories;

import com.library.entespotify.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByArtistsId(Long artistsId);
}
