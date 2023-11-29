package com.ltp.quickflix;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.format.annotation.DateTimeFormat;



public class Movie {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Integer id;
    private String title;
    private String genre;
    private int rating;
    private String cast;
    private String streamingService;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Movie() {
        this.id = count.incrementAndGet();
    }

    public Movie(Integer id, String title, String genre, LocalDate releaseDate, int rating, String cast, String streamingService) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cast = cast;
        this.streamingService = streamingService;
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

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getStreamingService() {
        return this.streamingService;
    }

    public void setStreamingService(String streamingService) {
        this.streamingService = streamingService;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}

