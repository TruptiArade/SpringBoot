package com.maptut.ManyToManyBidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Address")
@Data
@JsonIgnoreProperties("studentList")  // Ignore studentList during Address serialization
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String city;
    private String landmark;
    private String state;
    private String country;

    @JsonBackReference
    @ManyToMany (mappedBy = "addressList")
    private List<Student> studentList;
}