package com.movies.service;

import com.movies.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long movieId);

    Movie postMovie(Movie movie);

}
