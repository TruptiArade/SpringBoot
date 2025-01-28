package com.mapping.OnetoOneUnidirectional.service;

import com.mapping.OnetoOneUnidirectional.dto.EmployeeDTO;

import java.net.InterfaceAddress;
import java.util.List;

public interface EmployeeService
{
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> fetchEmployeeList();
}
