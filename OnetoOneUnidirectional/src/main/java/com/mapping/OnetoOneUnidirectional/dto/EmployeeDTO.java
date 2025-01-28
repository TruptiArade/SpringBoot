package com.mapping.OnetoOneUnidirectional.dto;

import com.mapping.OnetoOneUnidirectional.entity.Laptop;
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
