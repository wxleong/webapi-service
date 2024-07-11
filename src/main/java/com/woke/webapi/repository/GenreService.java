package com.woke.webapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<String> findAllGenreNames() {
        return genreRepository.findAllGenreNames();
    }
}
