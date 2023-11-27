package com.ltp.quickflix;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Movie {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Integer id;
    private String title;
    private String genre;
    private int rating;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Movie() {
        this.id = count.incrementAndGet();
    }

    public Movie(Integer id, String title, String genre, LocalDate releaseDate, int rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", genre='" + getGenre() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }
}

