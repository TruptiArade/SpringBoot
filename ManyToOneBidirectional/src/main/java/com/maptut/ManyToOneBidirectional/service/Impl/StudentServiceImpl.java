package com.maptut.ManyToOneBidirectional.service.Impl;

import com.maptut.ManyToOneBidirectional.dto.StudentDTO;
import com.maptut.ManyToOneBidirectional.entity.Question;

import com.maptut.ManyToOneBidirectional.entity.Student;
import com.maptut.ManyToOneBidirectional.repository.QuestionRepository;
import com.maptut.ManyToOneBidirectional.repository.StudentRepository;
import com.maptut.ManyToOneBidirectional.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO savestudent(StudentDTO studentDTO) {
        // Map the StudentDTO to a Student entity
        Student student = modelMapper.map(studentDTO, Student.class);

        // Fetch the associated Question entity using the questionId
        Question question = questionRepository.findById(studentDTO.getQuestion().getQid())
                .orElseThrow(() -> new RuntimeException("Question with ID " + studentDTO.getQuestion().getQid() + " not found"));

        // Set the Question object to the Student entity
        student.setQuestion(question);

        // Save the Student entity
        Student savedStudent = studentRepository.save(student);

        // Map the saved Student entity back to StudentDTO
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

