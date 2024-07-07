package com.woke.webapi.repository;

import com.woke.webapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Add custom query method
    List<Movie> findByTitleContaining(String title);
}
