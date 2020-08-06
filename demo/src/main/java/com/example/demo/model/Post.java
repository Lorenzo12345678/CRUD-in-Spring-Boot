package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Post {
    private String author;
    private String description;
    private UUID id;


    public Post(@JsonProperty("author") String author, @JsonProperty("description") String description, @JsonProperty("id") UUID id) {
        this.author = author;
        this.description = description;
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }
}
