package com.woke.webapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "genres")

    /**
     * @JsonIgnore is used to prevent recursive reading of movies and genres.
     * The downside is that it is unable to directly serialize the list of movies based on a genre.
     * This is to be improved in the future?
     */
    @JsonIgnore
    private Set<Movie> movies;
}
