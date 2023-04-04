package com.dh.apicatalog.controller;

import com.dh.apicatalog.client.MovieServiceClient;
import com.dh.apicatalog.client.SerieServiceClient;
import com.dh.apicatalog.service.CatalogService;
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

    @Autowired
    public SerieServiceClient serieServiceClient;

    @Autowired
    public CatalogService catalogService;

    //@GetMapping
    //public ResponseEntity<String> initController() {
    //    return ResponseEntity.ok("Genial");
    //}

    //@GetMapping("/{genre}")
    //public ResponseEntity<List<MovieServiceClient.MovieDTO>> getGenre(@PathVariable String genre, HttpServletResponse response) {
    //   ResponseEntity<List<MovieServiceClient.MovieDTO>> moviesResponse = ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
    //   System.out.println("LOAD BALANCER SELECTED PORT: " + moviesResponse.getHeaders().get("port"));
    //   return moviesResponse;
    //}


    // Modo online
    @GetMapping("/online/{genre}")
    public ResponseEntity<CatalogDTO> getByGenreOnline(@PathVariable String genre, HttpServletResponse response) {
       return ResponseEntity.ok(catalogService.getCatalogByGenreOnline(genre));
    }

    // Modo offline
    @GetMapping("/offline/{genre}")
    public ResponseEntity<CatalogDTO> getByGenreOffline(@PathVariable String genre, HttpServletResponse response) {
        return ResponseEntity.ok(catalogService.getCatalogByGenreOffline(genre));
    }
}
