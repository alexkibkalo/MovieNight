package com.kharkiv.movienight.transport.dto.movie;

import com.kharkiv.movienight.persistence.model.movie.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class MovieCreateDto {

    private String description;
    private String trailer;
    private Integer age;
    private byte[] image;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String language;

    @NotNull
    private Integer duration;

    @NotNull
    private Integer issue;

    @NotNull
    private Double rating;

    @NotNull
    private String genre;
}
