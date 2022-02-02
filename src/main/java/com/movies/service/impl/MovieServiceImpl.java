package com.movies.service.impl;

import com.movies.entity.Movie;
import com.movies.repository.MovieRepository;
import com.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * @return List of Movies
     * @apiNote returns List of Movies
     */
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * @return Movies
     * @apiNote returns existing Movie with movieId
     */
    @Override
    public Optional<Movie> getMovieById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    /**
     * @return Movie
     * @apiNote creates new Movie and return that Movie
     */
    @Override
    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
