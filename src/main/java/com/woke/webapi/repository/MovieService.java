package com.woke.webapi.repository;

import com.woke.webapi.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> findByTitleContaining(String title) {
        return movieRepository.findByTitleContaining(title);
    }
}
