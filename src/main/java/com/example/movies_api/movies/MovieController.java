package com.example.movies_api.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Anotação para o spring saber que esse é um controller
@RestController
// Irá controlar todas as requisições para a url definida
@RequestMapping("/api/v1/movies")
public class MovieController {

    // Autowired informa ao framework que queremos que ele instancie a classe para a gente
    @Autowired
    private MovieService movieService;
    // Irá lidar com toda requisição do tipo Get enviada para "/api/v1/movies"

    @GetMapping
    // Utilizar ResponseEntity no lugar de apenas uma String é bem importante, pois conseguimos passar de maneira fácil
    // os status da requisição.
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    // Procurando filme pelo Id
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
