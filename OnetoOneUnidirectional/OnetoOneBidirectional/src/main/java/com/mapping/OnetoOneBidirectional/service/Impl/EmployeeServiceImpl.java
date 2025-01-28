package com.mapping.OnetoOneBidirectional.service.Impl;

import com.mapping.OnetoOneBidirectional.dto.EmployeeDTO;
import com.mapping.OnetoOneBidirectional.entity.Employee;
import com.mapping.OnetoOneBidirectional.entity.Laptop;
import com.mapping.OnetoOneBidirectional.repository.EmployeeRepository;
import com.mapping.OnetoOneBidirectional.repository.LaptopRepository;
import com.mapping.OnetoOneBidirectional.service.EmployeeService;
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
