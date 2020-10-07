package com.kharkiv.movienight.transport.mapper.movie;

import com.kharkiv.movienight.persistence.model.movie.Movie;
import com.kharkiv.movienight.persistence.model.user.User;
import com.kharkiv.movienight.persistence.model.user.UserRole;
import com.kharkiv.movienight.service.actor.ActorService;
import com.kharkiv.movienight.transport.dto.movie.MovieCreateDto;
import com.kharkiv.movienight.transport.dto.user.UserOutcomeDto;
import com.kharkiv.movienight.transport.dto.user.UserRegistrationDto;
import com.kharkiv.movienight.transport.dto.user.UserUpdateDto;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;

@Mapper(imports = {Instant.class})
@Setter(onMethod_ = @Autowired)
public abstract class MovieMapper implements ActorService {

    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "updatedAt", expression = "java(Instant.now())")
    @Mapping(target = "createdBy", expression = "java(getActorFromContext())")
    @Mapping(target = "updatedBy", expression = "java(getActorFromContext())")
    public abstract Movie toEntity(MovieCreateDto dto);
}