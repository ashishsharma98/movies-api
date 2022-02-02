package com.movies.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceNotFoundExceptionTest {

    @Test
    public void resourceNotFoundExceptionTest(){
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("Not Found");
        assertEquals("Not Found", resourceNotFoundException.getMessage());
    }

}