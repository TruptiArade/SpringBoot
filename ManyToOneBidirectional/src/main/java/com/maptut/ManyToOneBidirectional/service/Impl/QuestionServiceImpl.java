package com.maptut.ManyToOneBidirectional.service.Impl;

import com.maptut.ManyToOneBidirectional.dto.QuestionDTO;
import com.maptut.ManyToOneBidirectional.entity.Question;
import com.maptut.ManyToOneBidirectional.repository.QuestionRepository;
import com.maptut.ManyToOneBidirectional.repository.StudentRepository;
import com.maptut.ManyToOneBidirectional.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDTO savequestion(QuestionDTO questionDTO)
    {
        Question q  =modelMapper.map(questionDTO,Question.class);
        Question savedata = questionRepository.save(q);
        return modelMapper.map(savedata, QuestionDTO.class);
    }

    @Override
    public List<QuestionDTO> fetchquestions()
    {
        List<Question> questionlist = questionRepository.findAll();
        return questionlist.stream()
                .map(entity -> modelMapper.map(entity, QuestionDTO.class))
                .collect(Collectors.toList());

    }
}
