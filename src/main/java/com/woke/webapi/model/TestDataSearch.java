package com.woke.webapi.model;

import com.woke.webapi.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDataSearch {
    private List<String> genres;
    private List<MovieDTO> movies;
}
