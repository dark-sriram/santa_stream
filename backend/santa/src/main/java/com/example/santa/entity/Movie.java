package com.example.santa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String embedUrl;

    public Movie() {}

    public Movie(Long id, String title, String embedUrl) {
        this.id = id;
        this.title = title;
        this.embedUrl = embedUrl;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getEmbedUrl() { return embedUrl; }
}
