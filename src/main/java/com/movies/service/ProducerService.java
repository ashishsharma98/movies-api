package com.movies.service;

import com.movies.entity.Producer;

import java.util.List;
import java.util.Optional;

public interface ProducerService {
    List<Producer> getAllProducer();

    Optional<Producer> getProducerById(Long producerId);

    Producer postProducer(Producer producer);
}
