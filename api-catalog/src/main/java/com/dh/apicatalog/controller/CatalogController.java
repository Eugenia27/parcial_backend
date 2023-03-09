package com.dh.apicatalog.controller;

import com.dh.apicatalog.client.MovieDto;
import com.dh.apicatalog.client.MovieServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/catalog")
public class CatalogController {

    @Autowired
    public MovieServiceClient movieServiceClient;

    @GetMapping
    public ResponseEntity<String> initController() {
        return ResponseEntity.ok("Genial");
    }


    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDto>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
    }
}
