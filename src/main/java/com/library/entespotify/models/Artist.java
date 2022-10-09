package com.library.entespotify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.entespotify.exceptions.EntityNotFoundException;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "artist_albums",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private Set<Album> albums;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "artist_tracks",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set<Track> tracks;

    public Artist(String name, Set<Album> albums, Set<Track> tracks) {
        this.name = name;
        this.albums = albums;
        this.tracks = tracks;
    }

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void setAlbum(Album album) {
        this.albums.add(album);
    }

    public void deleteAlbum(Album album) {
        this.albums.remove(album);
        album.getArtists().remove(this);
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public void setTrack(Track track) {
        this.tracks.add(track);
    }

    public void deleteTrack(Track track) {
        this.tracks.remove(track);
        track.getArtist().remove(this);
    }
}
