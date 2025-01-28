package com.maptut.ManyToOneUnidirectional.service;

import com.maptut.ManyToOneUnidirectional.dto.StudentDTO;

import java.util.List;

public interface StudentService
{
    StudentDTO savestudent(StudentDTO studentDTO);
    List<StudentDTO> fetchstudents();
}
