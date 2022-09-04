package com.library.entespotify.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "albums")
    private Set<Artist> artists;

    public Album(String title, Set<Artist> artists) {
        this.title = title;
        this.artists = artists;
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
}
