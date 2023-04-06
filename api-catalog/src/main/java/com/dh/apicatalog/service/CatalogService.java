package com.dh.apicatalog.service;

import com.dh.apicatalog.model.Movie;
import com.dh.apicatalog.model.Serie;
import com.dh.apicatalog.repository.MovieRepository;
import com.dh.apicatalog.repository.SerieRepository;
import com.dh.apicatalog.client.MovieServiceClient;
import com.dh.apicatalog.client.SerieServiceClient;
import com.dh.apicatalog.controller.CatalogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    MovieServiceClient movieServiceClient;
    @Autowired
    SerieServiceClient serieServiceClient;
    @Autowired
    SerieRepository serieRepository;
    @Autowired
    MovieRepository movieRepository;

    // Modo online
    public CatalogDTO getCatalogByGenreOnline(String genre) {
        List<MovieServiceClient.MovieDTO> moviesResponse = movieServiceClient.getMovieByGenre(genre);
        List<SerieServiceClient.SerieDTO> seriesResponse = serieServiceClient.getSerieByGenre(genre);
        CatalogDTO catalog = new CatalogDTO();
        catalog.setGenre(genre);
        catalog.setMovies(moviesResponse);
        catalog.setSeries(seriesResponse);
        return catalog;
    }

    // Modo offline
    public CatalogDTO getCatalogByGenreOffline(String genre) {
        List<Movie> moviesResponse = movieRepository.findByGenre(genre);
        List<Serie> seriesResponse = serieRepository(genre);
        CatalogDTO catalog = new CatalogDTO();
        catalog.setGenre(genre);
        catalog.setMovies(moviesResponse);
        catalog.setSeries(seriesResponse);
        return catalog;
    }


}
