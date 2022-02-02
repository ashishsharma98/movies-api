package com.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties
@Data
@ToString
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long actorId;

    private String actorName;
    private String bio;
    private LocalDate dateOfBirth;
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "actor_movie_id")
    @JsonBackReference
    private Movie movie;
}
