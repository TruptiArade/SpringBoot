package com.maptut.ManyToManyUnidirectional.service.Impl;

import com.maptut.ManyToManyUnidirectional.dto.AddressDTO;
import com.maptut.ManyToManyUnidirectional.dto.StudentDTO;
import com.maptut.ManyToManyUnidirectional.entity.Address;
import com.maptut.ManyToManyUnidirectional.entity.Student;
import com.maptut.ManyToManyUnidirectional.repository.AddressRepository;
import com.maptut.ManyToManyUnidirectional.repository.StudentRepository;
import com.maptut.ManyToManyUnidirectional.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*@Override
    public StudentDTO savestudent(StudentDTO studentDTO)
    {
        Student s=modelMapper.map(studentDTO,Student.class);
        Student savedata=studentRepository.save(s);
        return modelMapper.map(savedata, StudentDTO.class);
    }*/

    @Override
    public StudentDTO savestudent(StudentDTO studentDTO)
    {
        // Map the StudentDTO to the Student entity
        Student student = modelMapper.map(studentDTO, Student.class);

        // Check and fetch existing addresses by ID if provided in addressList
        if (studentDTO.getAddressList() != null) {
            List<Address> addressList = studentDTO.getAddressList().stream().map(addressDTO -> {
                if (addressDTO.getAid() != 0) {
                    // Fetch the existing Address by ID
                    return addressRepository.findById(addressDTO.getAid())
                            .orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressDTO.getAid()));
                } else {
                    throw new RuntimeException("Invalid address ID");
                }
            }).collect(Collectors.toList());

            // Set the address list to the Student
            student.setAddressList(addressList);
        }

        // Save the Student along with its associated Addresses
        Student savedStudent = studentRepository.save(student);

        // Map the saved Student back to a StudentDTO
        return modelMapper.map(savedStudent, StudentDTO.class);
    }



    @Override
    public List<StudentDTO> fetchstudents()
    {
        List<Student> studentlist = studentRepository.findAll();
        return studentlist.stream()
                .map(entity -> modelMapper.map(entity, StudentDTO.class))
                .collect(Collectors.toList());
    }

}
