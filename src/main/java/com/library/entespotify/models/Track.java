package com.library.entespotify.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "tracks")
    private Set<Artist> artist;
    private String album;


    Track() {
    }

    public Track(String title, Set<Artist> artist, String album) {

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

    public String getAlbum() {
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

    public void setAlbum(String album) {
        this.album = album;
    }

}
