package com.dh.apicatalog.controller;

import com.dh.apicatalog.client.MovieServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/catalog")
public class CatalogController {

    @Autowired
    public MovieServiceClient movieServiceClient;

    //@GetMapping
    //public ResponseEntity<String> initController() {
    //    return ResponseEntity.ok("Genial");
    //}


    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieServiceClient.MovieDTO>> getGenre(@PathVariable String genre, HttpServletResponse response) {
        ResponseEntity<List<MovieServiceClient.MovieDTO>> moviesResponse = ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
        System.out.println("LOAD BALANCER SELECTED PORT: " + moviesResponse.getHeaders().get("port"));
        return moviesResponse;
    }
}
