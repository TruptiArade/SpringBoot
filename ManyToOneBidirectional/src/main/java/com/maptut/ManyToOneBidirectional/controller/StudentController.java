package com.maptut.ManyToOneBidirectional.controller;

import com.maptut.ManyToOneBidirectional.dto.StudentDTO;
import com.maptut.ManyToOneBidirectional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("StudentInfo")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Add student

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
