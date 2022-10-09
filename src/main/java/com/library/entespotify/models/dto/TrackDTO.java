package com.library.entespotify.models.dto;

public class TrackDTO {
    private long id;
    private String title;

    public TrackDTO(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public TrackDTO() {
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
