package com.maptut.ManyToOneUnidirectional.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Student")
@Data
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sname;
    private int prn;

    //many to one question
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Question question;

}
