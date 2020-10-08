package com.kharkiv.movienight.transport.dto.movie;

import com.kharkiv.movienight.persistence.model.movie.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class MovieOutcomeDto {

    private String name;
    private Integer duration;
    private Instant issue;
    private Double rating;
    private String language;
    private String description;
    private String trailer;
    private Integer age;
    private Set<Genre> genre;
    private Long createdBy;
    private Instant createdAt;
    private Long updatedBy;
    private Instant updatedAt;
}
