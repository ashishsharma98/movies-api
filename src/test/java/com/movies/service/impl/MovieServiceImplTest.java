package com.movies.service.impl;

import com.movies.entity.Movie;
import com.movies.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieServiceImplTest {

    @Mock
    private MovieRepository repository;
    @InjectMocks
    MovieServiceImpl movieService;

    @Test
    void getAllMovies() {
        List<Movie> moviesList = movieService.getAllMovies();
        assertEquals(moviesList, movieService.getAllMovies());
    }

    @Test
    void getMovieById() {
        Optional<Movie> movie = movieService.getMovieById(1L);
        assertEquals(movie, movieService.getMovieById(1L));

    }

    @Test
    void postMovie() {
        Movie movie = new Movie();
        movie.setMovieId(1L);
        movie.setMovieName("Batman");
        movie.setReleaseDate(LocalDate.now());
        Mockito.when(repository.save(movie)).thenReturn(movie);
        assertEquals(movie,movieService.postMovie(movie));

    }
}