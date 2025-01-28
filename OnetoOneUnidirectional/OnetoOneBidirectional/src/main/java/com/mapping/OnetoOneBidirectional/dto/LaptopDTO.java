package com.mapping.OnetoOneBidirectional.dto;

import com.mapping.OnetoOneBidirectional.entity.Employee;
import lombok.Data;

@Data
public class LaptopDTO
{
    private int lid;
    private String lname;
    private String lmodel;
    private Employee employee;
}
