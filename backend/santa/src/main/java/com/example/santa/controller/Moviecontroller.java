package com.example.santa.controller;

import org.springframework.web.bind.annotation.*;

import com.example.santa.entity.Movie;
import com.example.santa.service.Movieservice;

@RestController
@RequestMapping("/api/movies")
public class Moviecontroller {

    private final Movieservice movieService;

    public Moviecontroller(Movieservice movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
}
