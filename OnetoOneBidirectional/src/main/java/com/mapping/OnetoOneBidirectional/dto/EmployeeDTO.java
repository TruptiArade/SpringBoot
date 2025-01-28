package com.mapping.OnetoOneBidirectional.dto;

import com.mapping.OnetoOneBidirectional.entity.Employee;
import com.mapping.OnetoOneBidirectional.entity.Laptop;
import lombok.Data;

@Data
public class EmployeeDTO
{
    private int eid;
    private String ename;
    private String ecompany;
    private String edesignation;
    private Laptop laptop;


}
