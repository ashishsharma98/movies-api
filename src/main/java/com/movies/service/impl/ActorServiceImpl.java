package com.movies.service.impl;

import com.movies.entity.Actor;
import com.movies.repository.ActorRepository;
import com.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    /**
     * @return List of Actors
     * @apiNote Returns list of Actors
     */
    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    /**
     * @return Actor
     * @apiNote Returns existing Actor with the actorId
     */
    @Override
    public Optional<Actor> getActorById(Long actorId) {
        return actorRepository.findById(actorId);
    }

    /**
     * @return Actor
     * @apiNote create new Actor in db
     */
    @Override
    public Actor postActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
