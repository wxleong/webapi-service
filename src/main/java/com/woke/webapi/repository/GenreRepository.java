package com.woke.webapi.repository;

import com.woke.webapi.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT g.name FROM Genre g")
    List<String> findAllGenreNames();
}
