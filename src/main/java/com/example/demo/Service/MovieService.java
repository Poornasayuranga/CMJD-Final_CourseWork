package com.example.demo.Service;

import com.example.demo.Entity.Movie;
import com.example.demo.Repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.Dto.MovieDto;



@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie( MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setID(movieDto.getID());
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setGenre(movieDto.getGenere());

        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, MovieDto movieDto) {

        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Movie not found with id: " + id
                        )
                );

        existingMovie.setTitle(movieDto.getTitle());
        existingMovie.setDescription(movieDto.getDescription());
        existingMovie.setLanguage(movieDto.getLanguage());
        existingMovie.setGenre(movieDto.getGenere());
        existingMovie.setReleaseDate(movieDto.getReleaseDate());
        existingMovie.setStatus(movieDto.getStatus());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(final Long id) {
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(final long id) {
        return movieRepository.getOne(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
