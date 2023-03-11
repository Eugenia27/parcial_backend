package com.dh.apicatalog.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
