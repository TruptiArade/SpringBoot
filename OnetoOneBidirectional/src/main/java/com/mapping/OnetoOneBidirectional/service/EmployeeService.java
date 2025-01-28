package com.mapping.OnetoOneBidirectional.service;

import com.mapping.OnetoOneBidirectional.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService
{
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> fetchEmployeeList();
}
