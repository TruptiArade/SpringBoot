package com.maptut.ManyToOneBidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qid;
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference  // Prevents serialization of the student list in Question
    private List<Student> studentList;
}

