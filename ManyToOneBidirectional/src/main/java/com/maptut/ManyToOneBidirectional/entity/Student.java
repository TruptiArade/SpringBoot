package com.maptut.ManyToOneBidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.tomcat.util.buf.C2BConverter;

@Entity
@Table(name="Student")
@Data

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sName;
    private int prn;

    @ManyToOne
    @JoinColumn(name="question_id")
    @JsonBackReference  // Ensures that the question is serialized in Student
    private Question question;
}
