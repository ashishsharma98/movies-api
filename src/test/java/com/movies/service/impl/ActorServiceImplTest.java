package com.movies.service.impl;

import com.movies.entity.Actor;
import com.movies.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ActorServiceImplTest {

    @Mock
    private ActorRepository repository;
    @InjectMocks
    ActorServiceImpl actorService;

    @Test
    void getAllActors() {
        List<Actor> actorsList = actorService.getAllActors();
        assertEquals(actorsList, actorService.getAllActors());
    }

    @Test
    void getActorById() {
        Optional<Actor> actor = actorService.getActorById(1L);
        assertEquals(actor, actorService.getActorById(1L));

    }

    @Test
    void postMovie() {
        Actor actor = new Actor();
        actor.setActorId(1L);
        actor.setActorName("Tom");
        actor.setBio("hero");
        Mockito.when(repository.save(actor)).thenReturn(actor);
        assertEquals(actor,actorService.postActor(actor));

    }

}