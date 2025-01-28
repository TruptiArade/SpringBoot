package com.maptut.ManyToManyUnidirectional.service;

import com.maptut.ManyToManyUnidirectional.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO savestudent(StudentDTO studentDTO);
    List<StudentDTO> fetchstudents();
}
