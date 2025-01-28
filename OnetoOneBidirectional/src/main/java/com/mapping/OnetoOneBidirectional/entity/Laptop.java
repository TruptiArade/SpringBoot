package com.mapping.OnetoOneBidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToOne(mappedBy = "laptop", cascade = CascadeType.ALL)
    @JsonBackReference
    private Employee employee;
}
