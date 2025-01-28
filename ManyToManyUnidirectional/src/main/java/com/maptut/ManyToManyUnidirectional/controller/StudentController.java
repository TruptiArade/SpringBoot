package com.maptut.ManyToManyUnidirectional.controller;

import com.maptut.ManyToManyUnidirectional.dto.StudentDTO;
import com.maptut.ManyToManyUnidirectional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("StudentInfo")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    StudentDTO savestudent(@RequestBody StudentDTO studentDTO)
    {
        return studentService.savestudent(studentDTO);
    }

    //Display all student
    @GetMapping("/studentlist")
    public List<StudentDTO> fetchstudents()
    {
        return studentService.fetchstudents();
    }
}
