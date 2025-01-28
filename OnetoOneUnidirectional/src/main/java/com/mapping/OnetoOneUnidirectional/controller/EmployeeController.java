package com.mapping.OnetoOneUnidirectional.controller;

import com.mapping.OnetoOneUnidirectional.dto.EmployeeDTO;
import com.mapping.OnetoOneUnidirectional.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmployeeInfo")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Add employee
    @PostMapping("/add")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO)

    {
        return employeeService.saveEmployee(employeeDTO);
    }

    //Display all employee
    @GetMapping("/employeelist")
    public List<EmployeeDTO> fetchEmployeeList()
    {
        return employeeService.fetchEmployeeList();
    }
}
