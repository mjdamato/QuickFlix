package com.ltp.quickflix;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service for managing movies.
 */
@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();

    /**
     * Returns a list of all movies.
     *
     * @return a list of all movies
     */
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    /**
     * Adds a movie to the list.
     *
     * @param movie the movie to add
     * @throws IllegalArgumentException if the movie's rating is not between 1 and 5
     */
    public void addMovie(Movie movie) {
        validateRating(movie);
        movies.add(movie);
    }

    /**
     * Updates a movie in the list.
     *
     * @param updatedMovie the updated movie
     * @throws IllegalArgumentException if the movie's rating is not between 1 and 5
     */
    public void updateMovie(Movie updatedMovie) {
        validateRating(updatedMovie);
        movies.removeIf(m -> m.getId().equals(updatedMovie.getId()));
        movies.add(updatedMovie);
    }

    /**
     * Deletes a movie from the list.
     *
     * @param movieId the ID of the movie to delete
     */
    public void deleteMovie(Integer movieId) {
        movies.removeIf(m -> m.getId().equals(movieId));
    }

    /**
     * Validates the rating of a movie.
     *
     * @param movie the movie to validate
     * @throws IllegalArgumentException if the movie's rating is not between 1 and 5
     */
    private void validateRating(Movie movie) {
        if (movie.getRating() < 1 || movie.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }

    /**
     * Returns the movie with the given ID.
     *
     * @param movieId the ID of the movie to return
     * @return the movie with the given ID, or null if no such movie exists
     */
    public Movie getMovieById(Integer movieId) {
        return movies.stream().filter(m -> m.getId().equals(movieId)).findFirst().orElse(null);
    }
}