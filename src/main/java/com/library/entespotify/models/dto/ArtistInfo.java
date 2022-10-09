package com.library.entespotify.models.dto;

import java.util.Set;

public class ArtistInfo {
    private long id;
    private String name;
    private Set<TrackDTO> tracks;
    private Set<AlbumDTO> albums;
    private String displayPicture;

    public ArtistInfo(int id, String name, Set<TrackDTO> tracks, Set<AlbumDTO> albums, String displayPicture) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.albums = albums;
        this.displayPicture = displayPicture;
    }

    public ArtistInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(Set<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public Set<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<AlbumDTO> albums) {
        this.albums = albums;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

}
