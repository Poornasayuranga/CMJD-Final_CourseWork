package com.example.demo.Controller;


import com.example.demo.Dto.MovieDto;
import com.example.demo.Entity.Movie;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.ShowRepository;
import com.example.demo.Service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")

public class MovieController {
    private final MovieService movieService;


    public MovieController(final  MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping
    public Movie createMovie(@RequestBody MovieDto movieDto){
        return movieService.createMovie(movieDto);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@RequestBody MovieDto movieDto,@PathVariable Long id){

        return movieService.updateMovie(id, movieDto);
    }


    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

}
