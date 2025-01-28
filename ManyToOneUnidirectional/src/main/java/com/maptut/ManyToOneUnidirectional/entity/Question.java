package com.maptut.ManyToOneUnidirectional.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Question")
@Data
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qid;
    private String question;
}