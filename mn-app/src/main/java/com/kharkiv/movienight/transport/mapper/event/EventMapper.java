package com.kharkiv.movienight.transport.mapper.event;

import com.kharkiv.movienight.persistence.model.event.Event;
import com.kharkiv.movienight.service.movie.MovieService;
import com.kharkiv.movienight.service.user.UserService;
import com.kharkiv.movienight.transport.dto.event.EventCreateDto;
import com.kharkiv.movienight.transport.dto.event.EventOutcomeDto;
import com.kharkiv.movienight.transport.dto.event.EventUpdateDto;
import com.kharkiv.movienight.transport.mapper.movie.MovieMapper;
import com.kharkiv.movienight.transport.mapper.user.UserMapper;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Mapper(imports = {Instant.class})
@Setter(onMethod_ = @Autowired)
public abstract class EventMapper {

    protected UserService userService;
    protected MovieService movieService;
    protected UserMapper userMapper;
    protected MovieMapper movieMapper;

    @Mapping(target = "movie", expression = "java(movieService.findById(dto.getMovieId()))")
    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "updatedAt", expression = "java(Instant.now())")
    public abstract Event toEntity(EventCreateDto dto);

    @Mapping(target = "movie", expression = "java(movieMapper.toDto(event.getMovie()))")
    @Mapping(target = "user", expression = "java(userMapper.toDto(event.getUser()))")
    @Mapping(target = "createdBy", source = "event.createdBy.id")
    @Mapping(target = "updatedBy", source = "event.updatedBy.id")
    @Mapping(target = "id", source = "event.id")
    public abstract EventOutcomeDto toDto(Event event);

    public abstract Event toEntity(EventUpdateDto dto, @MappingTarget Event event);
}