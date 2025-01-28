package com.maptut.ManyToOneUnidirectional.service.Impl;

import com.maptut.ManyToOneUnidirectional.dto.StudentDTO;
import com.maptut.ManyToOneUnidirectional.entity.Question;
import com.maptut.ManyToOneUnidirectional.entity.Student;
import com.maptut.ManyToOneUnidirectional.repository.QuestionRepository;
import com.maptut.ManyToOneUnidirectional.repository.StudentRepository;
import com.maptut.ManyToOneUnidirectional.service.StudentService;
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
        // Map the studentDTO to Student entity
        Student s = modelMapper.map(studentDTO, Student.class);

        // Get the Question object based on the question id
        Question question = questionRepository.findById(studentDTO.getQuestion().getQid())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Set the Question object to the student
        s.setQuestion(question);

        // Save the student and return the DTO
        Student savedStudent = studentRepository.save(s);
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

