package com.movies.service;

import com.movies.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<Actor> getAllActors();

    Optional<Actor> getActorById(Long actorId);

    Actor postActor(Actor actor);
}
