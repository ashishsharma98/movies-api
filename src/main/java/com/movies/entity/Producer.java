package com.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@ToString
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long producerId;
    private String producerName;
    private String bio;
    private String company;
    private LocalDate dataOfBirth;

    @OneToMany(
            mappedBy = "producer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Movie> movies;


}
