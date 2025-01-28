package com.maptut.ManyToManyUnidirectional.entity;

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

    //Many to Many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="Student_Address",
            joinColumns = @JoinColumn(name="sid"),
            inverseJoinColumns = @JoinColumn(name = "aid")
    )
    private List<Address> addressList;
}
