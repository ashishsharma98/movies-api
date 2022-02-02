package com.movies.controller;

import com.movies.entity.Movie;
import com.movies.exceptions.ResourceNotFoundException;
import com.movies.repository.MovieRepository;
import com.movies.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;
    @Mock
    private MovieService movieService;
    @Mock
    private MovieRepository repository;


    @Test
    void getAllMovies() {
        ResponseEntity<List<Movie>> movies = movieController.getAllMovies();
        assertEquals(movies, movieController.getAllMovies());
    }

    @Test
    void createMovies() {
        Movie movie = new Movie();
        movie.setMovieId(1L);
        movie.setMovieName("Batman");
        movie.setReleaseDate(LocalDate.now());

        ResponseEntity<Movie> result =movieController.createMovies(movie);
        assertEquals(result, movieController.createMovies(movie));
    }

    @Test
    void updateMovie() throws ResourceNotFoundException {
        Movie movie = new Movie();
        movie.setMovieId(1L);
        movie.setMovieName("Batman");
        movie.setReleaseDate(LocalDate.now());
        Mockito.when(movieService.getMovieById(1L)).thenReturn(java.util.Optional.of(movie));
        ResponseEntity<Movie> result =movieController.updateMovie(1L,movie);
        assertEquals(result, movieController.updateMovie(1L,movie));

    }
}