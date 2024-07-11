package com.woke.webapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String year;
    private Integer runtime;
    private String director;
    private String actors;
    private String plot;
    private String posterUrl;
    private List<String> genres;

    public MovieDTO(Long id, String title, String year, Integer runtime, String director, String actors, String plot, String posterUrl, String genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterUrl = posterUrl;
        this.genres = Arrays.asList(genres.split(","));
    }
}
