package com.maptut.ManyToManyUnidirectional.dto;

import com.maptut.ManyToManyUnidirectional.entity.Student;
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

}
