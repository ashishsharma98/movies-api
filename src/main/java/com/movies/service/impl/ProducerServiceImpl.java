package com.movies.service.impl;

import com.movies.entity.Producer;
import com.movies.repository.ProducerRepository;
import com.movies.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    /**
     * @return List of Producer
     * @apiNote returns List of Producer
     */
    @Override
    public List<Producer> getAllProducer() {
        return producerRepository.findAll();
    }

    /**
     * @return Producer
     * @apiNote returns existing Producer with producerId
     */
    @Override
    public Optional<Producer> getProducerById(Long producerId) {
        return producerRepository.findById(producerId);
    }

    /**
     * @return Producer
     * @apiNote creates new Producer and return that Producer
     */
    @Override
    public Producer postProducer(Producer producer) {
        return producerRepository.save(producer);
    }
}
