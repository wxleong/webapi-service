package com.woke.webapi.repository;

import com.woke.webapi.dto.MovieDTO;
import com.woke.webapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT new com.woke.webapi.dto.MovieDTO(m.id, m.title, m.year, m.runtime, m.director, m.actors, m.plot, m.posterUrl, "
            + "CAST(GROUP_CONCAT(g.name) AS string)) "
            + "FROM Movie m JOIN m.genres g "
            + "WHERE m.title LIKE %:title% "
            + "GROUP BY m.id, m.title, m.year, m.runtime, m.director, m.actors, m.plot, m.posterUrl")
    List<MovieDTO> findByTitleContaining(String title);
}
