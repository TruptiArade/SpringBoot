package com.maptut.onetomanyunidirectional.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Answer")
@Data
public class Answer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String answers;

}
