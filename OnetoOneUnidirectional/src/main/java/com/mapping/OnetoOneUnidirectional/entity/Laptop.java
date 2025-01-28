package com.mapping.OnetoOneUnidirectional.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Laptop")
@Data
public class Laptop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;
    private String lname;
    private String lmodel;
}
