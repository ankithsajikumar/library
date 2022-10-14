package com.library.entespotify.models.dto;

public class AlbumDTO {
    private long id;
    private String title;

    public AlbumDTO(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public AlbumDTO() {
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
}
