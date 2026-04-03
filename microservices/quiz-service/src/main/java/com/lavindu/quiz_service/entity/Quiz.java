package com.lavindu.quiz_service.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ElementCollection;
import lombok.Data;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    //@ManyToMany use when using entity relationship, here we are just storing question ids in quiz table, so we can get the questions from question service using those ids
    @ElementCollection
    private List<Integer> questionIds;
}