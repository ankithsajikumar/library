package com.library.entespotify.models.dto;

public class ArtistDTO {
    private long id;
    private String name;

    public ArtistDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistDTO() {
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
}
