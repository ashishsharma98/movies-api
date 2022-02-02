package com.movies.service.impl;

import com.movies.entity.Producer;
import com.movies.repository.ProducerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProducerServiceImplTest {

    @Mock
    private ProducerRepository repository;
    @InjectMocks
    ProducerServiceImpl producerService;

    @Test
    void getAllMovies() {
        List<Producer> producers = producerService.getAllProducer();
        assertEquals(producers, producerService.getAllProducer());
    }

    @Test
    void getMovieById() {
        Optional<Producer> producer = producerService.getProducerById(1L);
        assertEquals(producer, producerService.getProducerById(1L));

    }

    @Test
    void postMovie() {
        Producer producer = new Producer();
        producer.setProducerId(1L);
        producer.setProducerName("Ram");

        Mockito.when(repository.save(producer)).thenReturn(producer);
        assertEquals(producer, producerService.postProducer(producer));

    }

}