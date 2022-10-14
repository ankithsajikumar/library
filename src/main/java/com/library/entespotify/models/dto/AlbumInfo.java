package com.library.entespotify.models.dto;

import java.util.Set;

public class AlbumInfo {
    private long id;
    private String title;
    private Set<TrackDTO> tracks;
    private Set<ArtistDTO> artists;
    private String albumArt;

    public AlbumInfo(int id, String title, Set<TrackDTO> tracks, Set<ArtistDTO> artists, String albumArt) {
        this.id = id;
        this.title = title;
        this.tracks = tracks;
        this.artists = artists;
        this.albumArt = albumArt;
    }

    public AlbumInfo() {
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

    public Set<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(Set<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public Set<ArtistDTO> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistDTO> artists) {
        this.artists = artists;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }
}
