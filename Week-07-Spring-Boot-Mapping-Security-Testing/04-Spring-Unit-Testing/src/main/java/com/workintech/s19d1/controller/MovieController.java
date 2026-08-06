package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping
    public List<Movie> findAll() { return movieService.findAll(); }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id) { return movieService.findById(id); }

    @PostMapping
    public Movie save(@RequestBody Map<String, Object> request) {
        // Movie ve Actor birlikte kaydedilir
        Movie movie = new Movie();
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        movieService.delete(movie);
        return movie;
    }
}