package com.maptut.ManyToManyUnidirectional.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Address")
@Data
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String city;
    private String Landmark;
    private String State;
    private String Country;

}
