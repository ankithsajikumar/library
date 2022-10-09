package com.library.entespotify.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "albums")
    private Set<Artist> artists;

    @OneToMany(mappedBy = "album")
    private Set<Track> tracks;

    public Album(String title, Set<Artist> artists, Set<Track> tracks) {
        this.title = title;
        this.artists = artists;
        this.tracks = tracks;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
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
}
