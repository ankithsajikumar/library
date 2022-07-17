package com.library.entespotify.track;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="track")
public class Track {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String artist;
    private String album;


    Track() {}

    public Track(String title, String artist, String album) {

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

    public String getArtist() {
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

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}
