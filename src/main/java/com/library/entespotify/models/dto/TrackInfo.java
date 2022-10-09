package com.library.entespotify.models.dto;

import java.util.Set;

public class TrackInfo {
    private long id;
    private String title;
    private AlbumDTO album;
    private Set<ArtistDTO> artists;

    public TrackInfo(int id, String title, AlbumDTO album, Set<ArtistDTO> artists) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artists = artists;
    }

    public TrackInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public Set<ArtistDTO> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistDTO> artists) {
        this.artists = artists;
    }
}
