package com.mapping.OnetoOneUnidirectional.service.Impl;

import com.mapping.OnetoOneUnidirectional.dto.EmployeeDTO;
import com.mapping.OnetoOneUnidirectional.entity.Employee;
import com.mapping.OnetoOneUnidirectional.entity.Laptop;
import com.mapping.OnetoOneUnidirectional.repository.EmployeeRepository;
import com.mapping.OnetoOneUnidirectional.repository.LaptopRepository;
import com.mapping.OnetoOneUnidirectional.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO)
    {

        Employee e = modelMapper.map(employeeDTO, Employee.class);


        // Get the Laptop object based on the laptop id
        Laptop l = laptopRepository.findById(employeeDTO.getLaptop().getLid())
                .orElseThrow(() -> new RuntimeException("Laptop not found"));

        e.setLaptop(l);

        Employee savedEmployee = employeeRepository.save(e);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }


    @Override
    public List<EmployeeDTO> fetchEmployeeList()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream()
                .map(entity -> modelMapper.map(entity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
