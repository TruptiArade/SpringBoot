package com.maptut.ManyToManyUnidirectional.dto;

import com.maptut.ManyToManyUnidirectional.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class StudentDTO
{
    private int id;
    private String sname;
    private int prn;
    private List<Address> addressList;

}

