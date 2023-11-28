package com.ltp.quickflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Controller
@RequestMapping("/movies")
/**
 * Controller for handling movie related requests.
 */
public class MovieController {

    private final MovieService movieService;

    /**
     * Constructs a new MovieController with the given MovieService.
     *
     * @param movieService the MovieService to use
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Handles GET requests for "/movies".
     *
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("newMovie", new Movie());
        return "movies";
    }

    /**
     * Handles POST requests for "/movies/add".
     *
     * @param newMovie the new movie to add
     * @return the redirect view name
     */
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie newMovie) {
        movieService.addMovie(newMovie);
        return "redirect:/movies";
    }

    /**
     * Handles GET requests for "/movies/edit/{id}".
     *
     * @param id the ID of the movie to edit
     * @param model the model to add attributes to
     * @return the name of the view to render
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    /**
     * Handles POST requests for "/movies/update".
     *
     * @param movie the movie to update
     * @return the redirect view name
     */
    @PostMapping("/update")
    public String updateMovie(@ModelAttribute Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }

    /**
     * Handles GET requests for "/movies/delete/{id}".
     *
     * @param id the ID of the movie to delete
     * @return the redirect view name
     */
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}