package com.library.entespotify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tracks")
    private Set<Artist> artist;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    Track() {
    }

    public Track(String title, Set<Artist> artist, Album album) {

        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Set<Artist> getArtist() {
        return this.artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Set<Artist> artist) {
        this.artist = artist;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
