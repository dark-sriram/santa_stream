package com.example.santa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.santa.entity.Movie;

@Service
public class Movieservice {

    private static final Logger logger = LogManager.getLogger(Movieservice.class);

    public Movie getMovieById(Long id) {
        logger.info("Fetching movie {}", id);

        return new Movie(
                id,
                "Sample Movie",
                "https://vidsrc.cc/v2/embed/movie/" + id + "?autoPlay=false"
        );
    }
}
