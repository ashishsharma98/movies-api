package com.movies.controller;

import com.movies.entity.Movie;
import com.movies.exceptions.ResourceNotFoundException;
import com.movies.repository.MovieRepository;
import com.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;


    /**
     * @return List of Movies
     * @apiNote This Api returns List all movies with actor and producer information.
     */
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    /**
     * @return Movie details
     * @apiNote This Api is used to create movie with actor and producer information.
     */
    @PostMapping("/create-movie")
    public ResponseEntity<Movie> createMovies(@RequestBody Movie movies) {
        return ResponseEntity.ok(movieService.postMovie(movies));
    }

    /**
     * @return Updated Movie details
     * @apiNote This Api is used to update existing movie with actor and producer information.
     */
    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId,
                                             @RequestBody Movie movie) throws ResourceNotFoundException {
        Movie foundMovie = movieService.getMovieById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        foundMovie.setMovieId(movieId);
        foundMovie.setMovieName(movie.getMovieName());
        foundMovie.setPlot(movie.getPlot());
        foundMovie.setActors(movie.getActors());
        foundMovie.setProducer(movie.getProducer());
        foundMovie.setReleaseDate(movie.getReleaseDate());
        Movie updatedMovie = movieRepository.save(foundMovie);
        return ResponseEntity.ok(updatedMovie);
    }
}
