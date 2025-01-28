package com.maptut.ManyToManyBidirectional.service;

import com.maptut.ManyToManyBidirectional.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO savestudent(StudentDTO studentDTO);
    List<StudentDTO> fetchstudents();
}
