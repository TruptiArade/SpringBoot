package com.maptut.ManyToOneBidirectional.service;

import com.maptut.ManyToOneBidirectional.dto.StudentDTO;

import java.util.List;

public interface StudentService
{
    StudentDTO savestudent(StudentDTO studentDTO);
    List<StudentDTO> fetchstudents();
}
