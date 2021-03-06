package com.movienight.foundation.persistence.repository;

import com.movienight.foundation.persistence.model.event.Event;
import com.movienight.foundation.persistence.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event>, PagingAndSortingRepository<Event, Long> {

    Optional<Event> findByIdAndDeletedFalse(Long id);

    Optional<Event> findByIdAndDeletedTrue(Long id);

    boolean existsByCreatedByAndMovieId(User createdBy, Long movieId);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
