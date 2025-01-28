package com.maptut.ManyToManyBidirectional.dto;

import com.maptut.ManyToManyBidirectional.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class AddressDTO
{
    private int aid;
    private String city;
    private String Landmark;
    private String State;
    private String Country;
    private List<Student> studentList;
}