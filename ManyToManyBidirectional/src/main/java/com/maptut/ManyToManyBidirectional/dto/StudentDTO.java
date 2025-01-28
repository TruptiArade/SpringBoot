package com.maptut.ManyToManyBidirectional.dto;

import com.maptut.ManyToManyBidirectional.entity.Address;
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