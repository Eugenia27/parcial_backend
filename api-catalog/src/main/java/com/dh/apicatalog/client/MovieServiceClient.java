package com.dh.apicatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "api-movie")
public interface MovieServiceClient {

    @GetMapping("/api/v1/movies/{genre}")
    public List<MovieDto> getMovieByGenre(@PathVariable String genre);

//    @Getter
//    @Setter
//    class MovieDto {
//        private Long id;
//
//        private String name;
//
//        private String genre;
//
//        private String urlStream;
//    }


}
